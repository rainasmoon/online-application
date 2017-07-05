package io.netty.example.telnet;

import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.setContentLength;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;
import static io.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.net.InetAddress;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Handles a server-side channel.
 */
@Sharable
public class TelnetServerHandler extends SimpleChannelInboundHandler<Object> {

    final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private static Logger log = LoggerFactory.getLogger(TelnetServerHandler.class);

    private WebSocketServerHandshaker handshaker;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        channels.add(ctx.channel());

        // Send greeting for a new connection.
        ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName() + "!\r\n");
        ctx.write("It is " + new Date() + " now.\r\n");
        ctx.flush();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.debug("channel inactive...");

    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object request) throws Exception {
        // Generate and write a response.

        if (request instanceof FullHttpRequest) {
            log.debug(" ******************************channelRead0.http.");
            handleHttpRequest(ctx, (FullHttpRequest) request);
        } else if (request instanceof WebSocketFrame) {
            log.debug(" ******************************channelRead0.websocket");
            handleWebSocketFrame(ctx, (WebSocketFrame) request);

        } else if (request instanceof String) {
            String r = (String) request;

            String response;
            boolean close = false;
            if (r.isEmpty()) {
                response = "Please type something.\r\n";
            } else if ("bye".equals(r.toLowerCase())) {
                response = "Have a good day!\r\n";
                close = true;
            } else {
                response = "Did you say '" + r + "'?\r\n";
            }
            // We do not need to write a ChannelBuffer here.
            // We know the encoder inserted at TelnetPipelineFactory will do the conversion.
            ChannelFuture future = ctx.write(response);

            // Close the connection after sending 'Have a good day!'
            // if the client has sent 'bye'.
            if (close) {
                future.addListener(ChannelFutureListener.CLOSE);
            }
        } else {
            log.debug(" ******************************channelRead0.其他");
        }


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.debug(" ******************************userEventTriggered.心跳检测");
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state().equals(IdleState.READER_IDLE)) {

            } else if (event.state().equals(IdleState.WRITER_IDLE)) {

            } else if (event.state().equals(IdleState.ALL_IDLE)) {
            }
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        // 判断是否关闭链路的指令
        if (frame instanceof CloseWebSocketFrame) {
            log.debug(" ******************************关闭链路的指令");
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        // 判断是否ping消息
        if (frame instanceof PingWebSocketFrame) {
            log.debug(" ******************************ping消息");
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        // 图片暂时不做处理，交给接口处理。
        if (frame instanceof BinaryWebSocketFrame) {
            return;
        }
        // 非文字消息，不再处理。
        if (!(frame instanceof TextWebSocketFrame)) {
            return;
        }

    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        // Handle a bad request.
        if (!req.getDecoderResult().isSuccess()) {
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HTTP_1_1, BAD_REQUEST));
            return;
        }

        // Allow only GET methods.
        if (req.getMethod() != GET) {
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HTTP_1_1, FORBIDDEN));
            return;
        }

        // Send the demo page and favicon.ico
        if ("/".equals(req.getUri())) {
            ByteBuf content = Unpooled.copiedBuffer("welcome to your application...", CharsetUtil.US_ASCII);
            FullHttpResponse res = new DefaultFullHttpResponse(HTTP_1_1, OK, content);

            res.headers().set(CONTENT_TYPE, "text/html; charset=UTF-8");
            setContentLength(res, content.readableBytes());

            sendHttpResponse(ctx, req, res);
            return;
        }

        //
        if ("/favicon.ico".equals(req.getUri())) {
            FullHttpResponse res = new DefaultFullHttpResponse(HTTP_1_1, NOT_FOUND);
            sendHttpResponse(ctx, req, res);
            return;
        }

        // websocket - Handshake
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("welcome http: ...", null, false);
        handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            handshaker.handshake(ctx.channel(), req);
        }
    }

    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res) {
        // Generate an error page if response getStatus code is not OK (200).
        if (res.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.getStatus().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
            setContentLength(res, res.content().readableBytes());
        }

        // Send the response and close the connection if necessary.
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!isKeepAlive(req) || res.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }
}

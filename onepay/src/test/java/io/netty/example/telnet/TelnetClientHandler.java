package io.netty.example.telnet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Handles a client-side channel.
 */
@Sharable
public class TelnetClientHandler extends SimpleChannelInboundHandler<Object> {

    private static Logger log = LoggerFactory.getLogger(TelnetClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.debug("WebSocket客户端断开连接！ ");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.debug("WebSocket客户端断开连接！ ");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
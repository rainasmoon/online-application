package com.rainasmoon.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DiscardServerHandler extends SimpleChannelInboundHandler<Object> { // (1)

    Logger LOGGER = LoggerFactory.getLogger(DiscardServerHandler.class);


    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
        LOGGER.info("channel acvive...");

        final ByteBuf time = ctx.alloc().buffer(4); // (2)
        time.writeBytes("AA".getBytes());

        final ChannelFuture f = ctx.writeAndFlush(time); // (3)

        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                LOGGER.info("welcome msg sent.");
            }
        }); // (4)

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)

        LOGGER.info("channel read...");
        // write back the msg.
        ctx.write(msg); // (1)
        // release the msg
        ctx.flush(); // (2)


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)

        cause.printStackTrace();

        // Close the connection when an exception is raised.
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        LOGGER.info("channel read0...");

    }
}

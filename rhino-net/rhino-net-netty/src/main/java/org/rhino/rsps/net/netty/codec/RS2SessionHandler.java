package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.rhino.rsps.net.Controller;
import org.rhino.rsps.net.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class RS2SessionHandler extends ChannelInboundHandlerAdapter {

    /**
     * The logger for this class
     */
    private final Logger logger = LoggerFactory.getLogger(RS2SessionHandler.class);

    /**
     * The controller
     */
    private final Controller controller;

    public RS2SessionHandler(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("channel registered " + ctx.channel().remoteAddress());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("channel unregistered " + ctx.channel().remoteAddress());
    }

}

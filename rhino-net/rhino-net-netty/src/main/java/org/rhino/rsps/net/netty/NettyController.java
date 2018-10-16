package org.rhino.rsps.net.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.logging.LogManager;

public class NettyController {

    /**
     * The static logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(NettyController.class);

    /**
     * The port the service is bound to
     */
    private static int port = 43594;

    /**
     * The host the service is bound to
     */
    private static String host = "localhost";

    /**
     * The server bootstrap
     */
    private final ServerBootstrap bootstrap = new ServerBootstrap();

    /**
     * The boss event loop group
     */
    private final EventLoopGroup boss_group = new NioEventLoopGroup();

    /**
     * The worker event loop group
     */
    private final EventLoopGroup worker_group = new NioEventLoopGroup();

    /**
     * Starts the netty service
     */
    public void start() throws Exception {
        try {
            bootstrap.group(boss_group, worker_group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new NettyInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            /*
             * Bind and start to accept incoming connections.
             */
            ChannelFuture f = bootstrap.bind(host, port).sync();

            /*
             * Debug information
             */
            logger.info("Service started on port {}", port);

            /*
             * Wait until the server socket is closed to shut down the server
             */
            f.channel().closeFuture().sync();
        } finally {
            worker_group.shutdownGracefully();
            boss_group.shutdownGracefully();
        }
    }

}

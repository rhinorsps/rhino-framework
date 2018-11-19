package org.rhino.rsps.net.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.rhino.rsps.net.AsyncServer;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.netty.codec.ChannelPipelineInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer extends AsyncServer<ChannelFuture> {

    /**
     * The static logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    /**
     * The server context
     */
    private final ServerContext context;

    /**
     * The channel initializer
     */
    private final ChannelInitializer<SocketChannel> initializer;

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

    public NettyServer(ServerContext context) {
        this.context = context;
        this.initializer = new ChannelPipelineInitializer(context);
    }

    @Override
    public ChannelFuture asyncPublish() throws Exception {
        try {
            bootstrap.group(boss_group, worker_group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(initializer)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = bootstrap.bind(this.context.getHostAddress()).sync();
            logger.info("Service started on {}:{}", this.context.getHostAddress().getHostName(), this.context.getHostAddress().getPort());
            return f.channel().closeFuture().sync();
        } finally {
            worker_group.shutdownGracefully();
            boss_group.shutdownGracefully();
        }
    }

    @Override
    public void asyncClose() throws Exception {
        worker_group.shutdownGracefully();
        boss_group.shutdownGracefully();
    }

}

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
import org.rhino.rsps.net.netty.codec.NettyInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;

import static com.google.common.base.Preconditions.checkState;

public class NettyServer extends AsyncServer {

    /**
     * The static logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    /**
     *
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
        super(context);
        this.initializer = new NettyInitializer(context);
    }

    /**
     * Starts the netty service
     */
    public ChannelFuture serveAsync(ExecutorService service) throws Exception {
        try {
            bootstrap.group(boss_group, worker_group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(initializer)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = bootstrap.bind(super.getServerContext().getHostAddress()).sync();
            logger.info("Service started on {}:{}", super.getServerContext().getHostAddress());
            return f.channel().closeFuture().sync();
        } finally {
            worker_group.shutdownGracefully();
            boss_group.shutdownGracefully();
        }
    }

    @Override
    public void shutdownAsync(ExecutorService service) throws Exception {
        worker_group.shutdownGracefully();
        boss_group.shutdownGracefully();
    }

}

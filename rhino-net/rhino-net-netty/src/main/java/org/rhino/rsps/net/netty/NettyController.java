package org.rhino.rsps.net.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.rhino.rsps.net.AbstractController;
import org.rhino.rsps.net.AsyncController;
import org.rhino.rsps.net.netty.codec.NettyInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;

public class NettyController extends AsyncController {

    /**
     * The static logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(NettyController.class);

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

    public NettyController() {
    }

    public NettyController(ExecutorService service) {
        super(service);
    }

    /**
     * Starts the netty service
     */
    public ChannelFuture serveAsync(InetSocketAddress address, ExecutorService service) throws Exception {
        try {
            bootstrap.group(boss_group, worker_group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new NettyInitializer(null))
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = bootstrap.bind(address).sync();
            logger.info("Service started on {}:{}", address.getHostName(), address.getPort());
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

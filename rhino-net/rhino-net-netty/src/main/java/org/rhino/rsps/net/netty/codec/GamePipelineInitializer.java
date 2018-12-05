package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.rhino.rsps.core.session.SessionManager;
import org.rhino.rsps.net.ServerContext;

@ChannelHandler.Sharable
public class GamePipelineInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * The context of this controller
     */
    private final ServerContext context;

    public GamePipelineInitializer(ServerContext context) {
        this.context = context;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()
                .addLast("session-handler", new GameSessionHandler((SessionManager<SocketChannel>) context.getSessionManager()))
                .addLast("packet-codec", new GamePacketDecoder(context))
                .addLast("timeout", new IdleStateHandler(30, 0, 0));
    }

}

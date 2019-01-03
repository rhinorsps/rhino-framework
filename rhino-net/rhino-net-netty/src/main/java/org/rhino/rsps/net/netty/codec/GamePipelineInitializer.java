package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
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
                // handles sessions
                .addLast("session-handler", new GameSessionHandler((SessionManager<SocketChannel>) context.getSessionManager()))

                // Converts the raw byte stream into manageable packets
                .addLast("packet-decoder", new PacketDecoder(context))
                .addLast("packet-encoder", new PacketEncoder(context))

                // handles idle connections
                .addLast("timeout", new IdleStateHandler(15, 15, 15));
    }

}

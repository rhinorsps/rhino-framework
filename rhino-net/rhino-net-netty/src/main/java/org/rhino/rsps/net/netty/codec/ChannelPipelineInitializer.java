package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.session.SessionManager;

import java.net.Socket;

@ChannelHandler.Sharable
public class ChannelPipelineInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * The context of this controller
     */
    private final ServerContext context;

    public ChannelPipelineInitializer(ServerContext context) {
        this.context = context;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()
                .addLast("session", new SessionHandler((SessionManager<SocketChannel>) context.getSessionManager()))
                .addLast("packet", new PacketCodec(context.getPacketRepository()))
                .addLast("packet-handler", new PacketHandlerCodec(context.getPacketRepository()))
                .addLast("timeout", new IdleStateHandler(30, 0, 0));
    }

}

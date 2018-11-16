package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

@ChannelHandler.Sharable
public class NettyInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * The context of this controller
     */
    private final ServerContext context;

    public NettyInitializer(ServerContext context) {
        this.context = context;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()

                /**
                 * Associates and destroys sessions for connections
                 */
                .addLast("session-handler", new RS2SessionHandler(context.getSessionManager()))

                /**
                 * Codec for game messages (bytebuf <--> message)
                 */
                .addLast("game-codec", new PacketCodec(context.getRepository()))

                /*
                 * Disconnect channels that have been idle for 30 seconds or
                 * more
                 */
                .addLast("timeout", new IdleStateHandler(30, 0, 0));
    }

}

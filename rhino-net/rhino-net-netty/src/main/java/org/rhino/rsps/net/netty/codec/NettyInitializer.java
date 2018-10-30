package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.rhino.rsps.net.Controller;
import org.rhino.rsps.net.netty.codec.RS2GameCodec;
import org.rhino.rsps.net.netty.codec.RS2SessionHandler;

@ChannelHandler.Sharable
public class NettyInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()

                /**
                 * Associates and destroys sessions for connections
                 */
                .addLast("session-handler", new RS2SessionHandler())

                /**
                 * Codec for game messages (bytebuf <--> message)
                 */
                .addLast("game-codec", new RS2GameCodec())

                /*
                 * Disconnect channels that have been idle for 30 seconds or
                 * more
                 */
                .addLast("timeout", new IdleStateHandler(30, 0, 0));
    }

}

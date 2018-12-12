package org.rhino.rsps.bootstrap.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.rhino.rsps.net.ServerContext;

public class PacketEncoder extends MessageToByteEncoder<Object> {

    /**
     * The server context
     */
    private final ServerContext serverContext;

    /**
     *
     * @param serverContext
     */
    public PacketEncoder(ServerContext serverContext) {
        this.serverContext = serverContext;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Object packet, ByteBuf byteBuf) throws Exception {

    }

}
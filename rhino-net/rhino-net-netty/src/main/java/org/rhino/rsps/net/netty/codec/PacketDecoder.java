package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.rhino.rsps.net.ServerContext;

import java.util.List;

public class PacketDecoder extends ReplayingDecoder {

    /**
     * The packet
     */
    private final ServerContext context;

    /**
     * @param context
     */
    public PacketDecoder(ServerContext context) {
        this.context = context;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

    }

}

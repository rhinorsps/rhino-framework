package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.ServerContext;

import java.util.List;

public class MarshallingDecoder extends MessageToMessageDecoder<Packet> {

    /**
     *
     */
    private final ServerContext context;

    public MarshallingDecoder(ServerContext context) {
        this.context = context;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> list) throws Exception {

    }

}

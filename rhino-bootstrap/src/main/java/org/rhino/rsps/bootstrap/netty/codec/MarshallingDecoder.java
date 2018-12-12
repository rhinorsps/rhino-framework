package org.rhino.rsps.bootstrap.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.packet.Packet;

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

package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.packet.Packet;

import java.util.List;

/**
 * Turns an object into a packet
 */
public class MarshallingEncoder extends MessageToMessageEncoder<Object> {

    /**
     * The server context
     */
    private final ServerContext context;

    public MarshallingEncoder(ServerContext context) {
        this.context = context;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, List<Object> out) throws Exception {
        // no action required if it is already a packet
        if (o instanceof Packet) {
            out.add(o);
        }

        out.add(this.context.getMarshaller().marshal(o));
    }

}

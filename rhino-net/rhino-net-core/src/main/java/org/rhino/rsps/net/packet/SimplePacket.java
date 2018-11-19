package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.stream.InputStream;

public class SimplePacket implements Packet {

    private final InputStream payload;
    private final PacketDescriptor descriptor;

    public SimplePacket(InputStream payload, PacketDescriptor descriptor) {
        this.payload = payload;
        this.descriptor = descriptor;
    }

    @Override
    public InputStream getPayload() {
        return this.payload;
    }

    @Override
    public PacketDescriptor getDescriptor() {
        return this.descriptor;
    }
}

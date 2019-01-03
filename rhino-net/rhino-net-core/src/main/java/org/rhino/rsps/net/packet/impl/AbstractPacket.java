package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.stream.InputStream;

public abstract class AbstractPacket implements Packet {

    private final PacketIdentifier identifier;
    private final InputStream payload;

    public AbstractPacket(PacketIdentifier identifier, InputStream payload) {
        this.identifier = identifier;
        this.payload = payload;
    }

    @Override
    public PacketIdentifier getIdentifier() {
        return this.identifier;
    }

    @Override
    public InputStream getPayload() {
        return this.payload;
    }

}

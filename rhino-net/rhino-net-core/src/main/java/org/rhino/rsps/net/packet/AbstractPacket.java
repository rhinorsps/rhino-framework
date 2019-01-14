package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.stream.InputStream;

/**
 * Simple packet implementation
 */
public abstract class AbstractPacket implements Packet {

    private final PacketIdentifier identifier;
    private final int length;
    private final MetaData metaData;
    private final InputStream payload;

    public AbstractPacket(PacketIdentifier identifier, int length, MetaData metaData, InputStream payload) {
        this.identifier = identifier;
        this.length = length;
        this.metaData = metaData;
        this.payload = payload;
    }

    @Override
    public PacketIdentifier getIdentifier() {
        return this.identifier;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public MetaData getMetaData() {
        return this.metaData;
    }

    @Override
    public InputStream getPayload() {
        return this.payload;
    }

}

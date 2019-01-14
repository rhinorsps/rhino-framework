package org.rhino.rsps.net.packet.impl;

import org.rhino.rsps.net.packet.AbstractPacket;
import org.rhino.rsps.net.packet.MetaData;
import org.rhino.rsps.net.packet.PacketIdentifier;
import org.rhino.rsps.net.stream.InputStream;

/**
 * A read-only packet. This cannot be serialized or edited after creation.
 */
public class ReadOnlyPacket extends AbstractPacket {

    public ReadOnlyPacket(PacketIdentifier identifier, int length, MetaData metaData, InputStream payload) {
        super(identifier, length, metaData, payload);
    }

}

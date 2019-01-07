package org.rhino.rsps.net.packet.impl;

import org.rhino.rsps.net.packet.PacketIdentifier;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

/**
 * Read-only packets, cannot be serialized
 */
public class ReadOnlyPacket extends AbstractPacket {

    public ReadOnlyPacket(PacketIdentifier identifier, InputStream payload) {
        super(identifier, payload);
    }

}

package org.rhino.rsps.net.packet.impl;

import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketIdentifier;
import org.rhino.rsps.net.stream.InputStream;

/**
 * The default packet
 */
public class ReadOnlyPacket extends AbstractPacket {

    public ReadOnlyPacket(PacketIdentifier identifier, InputStream payload) {
        super (identifier, payload);
    }

}

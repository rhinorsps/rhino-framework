package org.rhino.rsps.net.packet.impl;

import org.rhino.rsps.net.packet.PacketIdentifier;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

public class SimplePacket extends AbstractPacket {

    public SimplePacket(PacketIdentifier identifier, InputStream payload) {
        super(identifier, payload);
    }

}

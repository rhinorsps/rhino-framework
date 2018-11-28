package org.rhino.rsps.bootstrap.autoconfigure.net.packet.handler;

import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDescriptor;
import org.rhino.rsps.net.packet.handler.InputStreamPacketHandler;
import org.rhino.rsps.net.session.SessionContext;

public class AutoDiscoverInputStreamHandler implements InputStreamPacketHandler {

    @Override
    public Object handlePacket(Packet packet, PacketDescriptor packetDescriptor, SessionContext sessionContext) throws Exception {
        return null;
    }

}

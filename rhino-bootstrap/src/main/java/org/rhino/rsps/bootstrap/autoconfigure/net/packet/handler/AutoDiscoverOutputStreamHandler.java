package org.rhino.rsps.bootstrap.autoconfigure.net.packet.handler;

import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDescriptor;
import org.rhino.rsps.net.packet.handler.OutputStreamPacketHandler;
import org.rhino.rsps.net.session.SessionContext;

/**
 *
 */
public class AutoDiscoverOutputStreamHandler implements OutputStreamPacketHandler {



    @Override
    public Packet handlePacket(Object partial, PacketDescriptor packetDescriptor, SessionContext sessionContext) throws Exception {
        return null;
    }

}

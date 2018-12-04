package org.rhino.rsps.net.packet.handler;

import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDescriptor;
import org.rhino.rsps.net.packet.PacketHandler;
import org.rhino.rsps.net.session.SessionContext;

public interface InputStreamPacketHandler extends PacketHandler<Packet, Object> {

    @Override
    default Object handlePacket(Packet input, PacketDescriptor descriptor, SessionContext context) throws Exception {
        return null;
    }



}

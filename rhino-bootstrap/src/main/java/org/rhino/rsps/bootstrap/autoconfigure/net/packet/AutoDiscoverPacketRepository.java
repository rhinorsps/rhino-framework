package org.rhino.rsps.bootstrap.autoconfigure.net.packet;

import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDescriptor;
import org.rhino.rsps.net.packet.PacketHandler;
import org.rhino.rsps.net.packet.PacketRepository;
import org.rhino.rsps.net.session.SessionContext;

public class AutoDiscoverPacketRepository implements PacketRepository {

    @Override
    public PacketHandler<Packet, Object> getInputStreamHandler(PacketDescriptor packetDescriptor, SessionContext sessionContext) {
        return null;
    }

    @Override
    public PacketHandler<Object, Packet> getOutputStreamHandler(PacketDescriptor packetDescriptor, SessionContext sessionContext) {
        return null;
    }

    @Override
    public PacketDescriptor getInputStreamDescriptor(int opcode, SessionContext sessionContext) {
        return null;
    }

    @Override
    public PacketDescriptor getOutputStreamDescriptor(Class<?> model, SessionContext sessionContext) {
        return null;
    }

}

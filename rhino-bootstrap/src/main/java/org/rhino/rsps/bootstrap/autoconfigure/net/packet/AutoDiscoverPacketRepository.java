package org.rhino.rsps.bootstrap.autoconfigure.net.packet;

import org.rhino.rsps.net.packet.PacketDescriptor;
import org.rhino.rsps.net.packet.PacketRepository;
import org.rhino.rsps.net.packet.handler.InputStreamPacketHandler;
import org.rhino.rsps.net.packet.handler.OutputStreamPacketHandler;
import org.rhino.rsps.net.session.SessionContext;

public class AutoDiscoverPacketRepository implements PacketRepository {


    @Override
    public InputStreamPacketHandler getInputStreamHandler(PacketDescriptor packetDescriptor, SessionContext sessionContext) {
        return null;
    }

    @Override
    public OutputStreamPacketHandler getOutputStreamHandler(PacketDescriptor packetDescriptor, SessionContext sessionContext) {
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

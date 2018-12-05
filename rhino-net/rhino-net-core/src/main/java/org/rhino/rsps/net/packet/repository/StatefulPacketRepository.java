package org.rhino.rsps.net.packet.repository;

import org.rhino.rsps.net.packet.PacketDescriptor;
import org.rhino.rsps.net.session.SessionContext;

public interface StatefulPacketRepository<KEY> {

    /**
     *
     * @param state
     * @return
     */
    PacketRepository<KEY> getRepository(SessionContext.State state);

}

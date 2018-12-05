package org.rhino.rsps.net.packet.repository;

import org.rhino.rsps.net.packet.PacketDescriptor;

public interface PacketRepository<KEY> {

    /**
     * Gets the descriptor for the given opcode
     *
     * @param key
     * @return
     */
    PacketDescriptor getDescriptor(KEY key);

}

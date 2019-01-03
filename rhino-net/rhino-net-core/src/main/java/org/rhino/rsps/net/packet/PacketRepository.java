package org.rhino.rsps.net.packet;

public interface PacketRepository {



    /**
     * Gets the definition of a packet for a given identifier
     *
     * @param identifier
     * @return
     */
    PacketDefinition getPacketDefinition(PacketIdentifier identifier);

}

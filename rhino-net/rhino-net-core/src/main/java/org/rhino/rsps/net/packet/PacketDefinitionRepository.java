package org.rhino.rsps.net.packet;

public interface PacketDefinitionRepository {

    /**
     * Gets the definition to decode a packet
     *
     * @param identifier
     * @return
     */
    PacketDefinition getDecodeDefinition(PacketIdentifier identifier);

    /**
     * Gets the definition to encode a packet
     *
     * @param identifier
     * @return
     */
    PacketDefinition getEncodeDefinition(PacketIdentifier identifier);

}

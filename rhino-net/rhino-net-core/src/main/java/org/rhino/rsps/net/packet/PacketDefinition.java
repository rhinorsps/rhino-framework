package org.rhino.rsps.net.packet;

public interface PacketDefinition {

    /**
     * Gets the packet's expected length
     * @return
     */
    int getExpectedLength();

    /**
     * Gets the packet meta data
     *
     * @return
     */
    Packet.MetaData getMetaData();

    /**
     * Gets the packet identifier
     *
     * @return
     */
    PacketIdentifier getIdentifier();

}

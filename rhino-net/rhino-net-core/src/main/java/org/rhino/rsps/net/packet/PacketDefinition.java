package org.rhino.rsps.net.packet;

public interface PacketDefinition {

    /**
     * The packet's identifier
     *
     * @return
     */
    PacketIdentifier getIdentifier();

    /**
     * The packet's length
     *
     * @return
     */
    int getLength();

    /**
     * The packet's meta data
     *
     * @return
     */
    MetaData getMetaData();

}

package org.rhino.rsps.net.packet;

/**
 * The packet identifier. Since opcodes can be re-used in between states it's important that the identifier
 * also has a way of displaying what state the packet is in.
 */
public interface PacketIdentifier {

    /**
     * @return
     */
    int getOpcode();

    /**
     * @return
     */
    State getState();

}

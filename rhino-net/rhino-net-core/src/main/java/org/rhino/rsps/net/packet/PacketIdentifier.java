package org.rhino.rsps.net.packet;

public interface PacketIdentifier {

    /**
     * Gets the game state
     *
     * @return
     */
    ConnectionState getState();

    /**
     * Gets the opcode
     *
     * @return
     */
    int getOpcode();

}

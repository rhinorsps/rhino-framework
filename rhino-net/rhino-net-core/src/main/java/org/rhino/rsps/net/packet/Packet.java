package org.rhino.rsps.net.packet;

public interface Packet {

    /**
     * The packet's identifier. This contains information in which stage it is expected and what the opcode is.
     *
     * @return
     */
    int getOpcode();

    /**
     * Gets the packet's payload
     *
     * @return
     */
    Payload getPayload();

}

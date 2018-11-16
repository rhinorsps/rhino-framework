package org.rhino.rsps.net.packet;

public interface PacketDescriptor {

    /**
     * @return
     */
    int getOpcode();

    /**
     * @return
     */
    Header getHeader();

    /**
     *
     */
    enum Header {
        FIXED, VARIABLE_8_BIT, VARIABLE_16_BIT;
    }

}

package org.rhino.rsps.net.packet;

public interface PacketDescriptor {

    /**
     * @return
     */
    int getOpcode();

    /**
     *
     * @return
     */
    int getExpectedLength();

    /**
     * @return
     */
    Header getHeader();

    /**
     * The class' model
     *
     * @return
     */
    Class<?> getModel();

    /**
     *
     */
    enum Header {
        FIXED, VARIABLE_8_BIT, VARIABLE_16_BIT;
    }

}

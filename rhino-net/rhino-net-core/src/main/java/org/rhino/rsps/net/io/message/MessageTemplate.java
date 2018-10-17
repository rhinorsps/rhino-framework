package org.rhino.rsps.net.io.message;

public interface MessageTemplate {

    /**
     * Gets the expected opcode of the message
     *
     * @return
     */
    int getExpectedOpcode();

    /**
     * Gets the expected length of the message
     * @return
     */
    int getExpectedLength();

}

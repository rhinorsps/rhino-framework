package org.rhino.rsps.net.io.message;

public interface MessageTemplate {

    /**
     * Gets the expected opcode of the message
     *
     * @return
     */
    int getExpectedOpcode();

    /**
     * gets the expected length of the message
     * @return
     */
    Type getType();

    enum Type {
        FIXED_SIZE, VARIABLE_BYTE, VARIABLE_SHORT;
    }

}

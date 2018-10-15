package org.rhino.rsps.net.io.message;

/**
 * Represents the header of a message
 */
public interface Header {

    /**
     * Gets the length
     *
     * @return
     */
    int getLength();

    /**
     * Gets the opcode
     *
     * @return
     */
    int getOpcode();

}

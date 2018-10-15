package org.rhino.rsps.net.io.message;

import org.rhino.rsps.net.io.InputStream;
import org.rhino.rsps.net.io.OutputStream;

import java.io.IOException;

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

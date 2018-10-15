package org.rhino.rsps.net.io.message;

import org.rhino.rsps.net.io.InputStream;
import org.rhino.rsps.net.io.OutputStream;

import java.io.IOException;

/**
 * Represents the payload of a message
 */
public interface Payload {

    /**
     * Gets the payload's expected length
     *
     * @return
     */
    int getExpectedLength();

}

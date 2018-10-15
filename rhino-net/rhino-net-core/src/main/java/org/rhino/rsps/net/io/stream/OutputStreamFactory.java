package org.rhino.rsps.net.io.stream;

import java.io.IOException;

/**
 * Needs to be implemented by networking implementation.
 */
public interface OutputStreamFactory {

    /**
     * Creates a default {@link OutputStream}. Used for when the length of data that needs to be written is unknown.
     *
     * @return
     * @throws Exception
     */
    OutputStream createOutputStream() throws IOException;

    /**
     * Creates an {@link OutputStream} with a given amount of data available to be written.
     *
     * @param length
     * @return
     */
    OutputStream createOutputStream(int length) throws IOException;

}

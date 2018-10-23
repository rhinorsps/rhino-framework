package org.rhino.rsps.net.stream;

import java.io.IOException;

interface Stream extends AutoCloseable {

    /**
     * The default endianness should none be given
     */
    Endianness DEFAULT_ENDIANNESS = Endianness.BIG_ENDIAN;

    /**
     * amount of data available
     *
     * @return
     * @throws IOException
     */
    int available() throws IOException;

    /**
     * Closes the stream
     *
     * @throws IOException
     */
    void close() throws IOException;

    /**
     * indicates whether or not the stream is closed
     *
     * @return
     * @throws IOException
     */
    boolean isClosed() throws IOException;
}

package org.rhino.rsps.net.io;

import java.io.IOException;

interface DataStream {

    /**
     * amount of data available
     *
     * @return
     * @throws IOException
     */
    long available() throws IOException;

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

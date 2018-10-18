package org.rhino.rsps.net.io.stream;

import java.io.IOException;

public interface InputStream extends DataStream {

    /**
     * Reads a byte with the given {@link Endianness}
     *
     * @return
     * @throws IOException
     */
    int readByte() throws IOException;

    /**
     * Reads a short (2 bytes) with the given {@link Endianness}
     * @return
     * @throws IOException
     */
    int readShort() throws IOException;

    /**
     * Reads a medium (3 bytes) with the given {@link Endianness}
     *
     * @return
     * @throws IOException
     */
    int readMedium() throws IOException;

    /**
     * Reads an integer with the given {@link Endianness}
     * @return
     * @throws IOException
     */
    int readInteger() throws IOException;

    /**
     * Reads a long (8 bytes) with the given {@link Endianness}
     * @return
     * @throws IOException
     */
    long readLong() throws IOException;

    /**
     *
     * @return
     * @throws IOException
     */
    byte[] readFully() throws IOException;

}

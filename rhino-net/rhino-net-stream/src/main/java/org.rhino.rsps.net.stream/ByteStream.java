package org.rhino.rsps.net.stream;

import org.rhino.rsps.net.stream.mutator.Endianness;
import org.rhino.rsps.net.stream.mutator.Operand;

import java.io.IOException;

public interface ByteStream extends AutoCloseable {

    /**
     * The default endianness should none be given
     */
    Endianness DEFAULT_ENDIANNESS = Endianness.BIG_ENDIAN;

    /**
     * The default operand, should none be given
     */
    Operand DEFAULT_OPERAND = Operand.NO_OP;

    /**
     * Gets an array of bytes
     *
     * @return
     */
    byte[] array();

    /**
     * amount of data available
     *
     * @return
     * @throws IOException
     */
    int available() throws IOException;

    /**
     *
     * @return
     */
    int capacity();

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

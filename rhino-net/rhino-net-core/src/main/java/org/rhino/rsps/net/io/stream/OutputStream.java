package org.rhino.rsps.net.io.stream;

import java.io.IOException;

/**
 * A class that represents where the data is being written to. Could be written to a byte array, ByteBuffer or
 * an implementation dependant backing buffer.
 */
public interface OutputStream extends DataStream {

    /**
     *
     * @return
     */
    byte[] array();

    /**
     *
     * @param data
     * @throws IOException
     */
    void writeBytes(byte[] data) throws IOException;

    /**
     *
     * @param out
     * @throws IOException
     */
    void write(OutputStream out) throws IOException;

    /**
     * Writes a byte with the given {@link Endianness}
     *
     * @return
     * @throws IOException
     */
    void writeByte(int value) throws IOException;

    /**
     * Writes a short (2 bytes) with the given {@link Endianness}
     * @return
     * @throws IOException
     */
    void writeShort(int value) throws IOException;

    /**
     * Writes a medium (3 bytes) with the given {@link Endianness}
     *
     * @return
     * @throws IOException
     */
    void writeMedium(int value) throws IOException;

    /**
     * Writes an integer with the given {@link Endianness}
     * @return
     * @throws IOException
     */
    void writeInteger(int value) throws IOException;

    /**
     * Writes a long (8 bytes) with the given {@link Endianness}
     * @return
     * @throws IOException
     */
    void writeLong(long value) throws IOException;

}

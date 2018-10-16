package org.rhino.rsps.net.io.stream;

import java.io.IOException;

/**
 * A class that represents where the data is being written to. Could be written to a byte array, ByteBuffer or
 * an implementation dependant backing buffer.
 */
public interface OutputStream extends DataStream {

    /**
     * Writes a byte with the given {@link Endianness}
     *
     * @return
     * @throws IOException
     */
    void writeByte(int value) throws IOException;

    /**
     * Writes a short (2 bytes) with the given {@link Endianness}
     * @param endianness
     * @return
     * @throws IOException
     */
    void writeShort(int value, Endianness endianness) throws IOException;

    /**
     * Writes a medium (3 bytes) with the given {@link Endianness}
     *
     * @param endianness
     * @return
     * @throws IOException
     */
    void writeMedium(int value, Endianness endianness) throws IOException;

    /**
     * Writes an integer with the given {@link Endianness}
     * @param endianness
     * @return
     * @throws IOException
     */
    void writeInteger(int value, Endianness endianness) throws IOException;

    /**
     * Writes a long (8 bytes) with the given {@link Endianness}
     * @param endianness
     * @return
     * @throws IOException
     */
    void writeLong(long value, Endianness endianness) throws IOException;

    /**
     * Helper method write a short with default endianness (LITTLE_ENDIAN)
     *
     * @param value
     * @throws IOException
     */
    default void writeShort(int value) throws IOException {
        this.writeShort(value, DEFAULT_ENDIANESS);
    }

    /**
     * Helper method write a medium with default endianness (LITTLE_ENDIAN)
     *
     * @param value
     * @throws IOException
     */
    default void writeMedium(int value) throws IOException {
        this.writeMedium(value, DEFAULT_ENDIANESS);
    }

    /**
     * Helper method write an integer with default endianness (LITTLE_ENDIAN)
     *
     * @param value
     * @throws IOException
     */
    default void writeInteger(int value) throws IOException {
        this.writeInteger(value, DEFAULT_ENDIANESS);
    }

    /**
     * Helper method write a long with default endianness (LITTLE_ENDIAN)
     *
     * @param value
     * @throws IOException
     */
    default void writeLong(long value) throws IOException {
        this.writeLong(value, DEFAULT_ENDIANESS);
    }
}

package org.rhino.rsps.net.io.stream;

import java.io.IOException;

public interface InputStream extends DataStream {

    /**
     * Reads a byte with the given {@link Endianness}
     *
     * @param endianness
     * @return
     * @throws IOException
     */
    int readByte(Endianness endianness) throws IOException;

    /**
     * Reads a short (2 bytes) with the given {@link Endianness}
     * @param endianness
     * @return
     * @throws IOException
     */
    int readShort(Endianness endianness) throws IOException;

    /**
     * Reads a medium (3 bytes) with the given {@link Endianness}
     *
     * @param endianness
     * @return
     * @throws IOException
     */
    int readMedium(Endianness endianness) throws IOException;

    /**
     * Reads an integer with the given {@link Endianness}
     * @param endianness
     * @return
     * @throws IOException
     */
    int readInteger(Endianness endianness) throws IOException;

    /**
     * Reads a long (8 bytes) with the given {@link Endianness}
     * @param endianness
     * @return
     * @throws IOException
     */
    long readLong(Endianness endianness) throws IOException;

    /**
     * Helper method to read a byte with default {@link Endianness} (little-endian)
     *
     * @return
     * @throws IOException
     */
    default int readByte() throws IOException {
        return this.readByte(Endianness.LITTLE_ENDIAN);
    }

    /**
     * Helper method to read a short with default {@link Endianness} (little-endian)
     *
     * @return
     * @throws IOException
     */
    default int readShort() throws IOException {
        return this.readShort(Endianness.LITTLE_ENDIAN);
    }

    /**
     * Helper method to medium a byte with default {@link Endianness} (little-endian)
     *
     * @return
     * @throws IOException
     */
    default int readMedium() throws IOException {
        return this.readMedium(Endianness.LITTLE_ENDIAN);
    }

    /**
     * Helper method to read an integer with default {@link Endianness} (little-endian)
     *
     * @return
     * @throws IOException
     */
    default int readInteger() throws IOException {
        return this.readInteger(Endianness.LITTLE_ENDIAN);
    }

    /**
     * Helper method to read a long with default {@link Endianness} (little-endian)
     *
     * @return
     * @throws IOException
     */
    default long readLong() throws IOException {
        return this.readLong(Endianness.LITTLE_ENDIAN);
    }

}

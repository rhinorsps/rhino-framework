package org.rhino.rsps.net.stream;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkArgument;

public interface InputStream extends Stream {

    /**
     *
     * @return
     * @throws IOException
     */
    int poll() throws IOException;

    /**
     * Reads a byte and applies the transformation
     *
     * @return
     * @throws IOException
     */
    default int readByte(Operand operand) throws IOException {
        return operand.apply(this.poll());
    }

    /**
     * Reads a short (2 bytes) with the given {@link Endianness} and operand
     * @return
     * @throws IOException
     */
    default int readShort(Endianness endianness, Operand operand) throws IOException {
        checkArgument(endianness == Endianness.LITTLE_ENDIAN || endianness == Endianness.BIG_ENDIAN,"can only store short in LITTLE_ENDIAN or BIG_ENDIAN");

        return 0;
    }

}


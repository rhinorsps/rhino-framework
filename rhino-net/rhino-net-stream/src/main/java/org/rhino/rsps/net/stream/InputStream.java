package org.rhino.rsps.net.stream;

import java.io.IOException;
import java.nio.ByteBuffer;

import static com.google.common.base.Preconditions.checkArgument;

public interface InputStream extends Stream {

    /**
     *
     * @return
     * @throws IOException
     */
    byte poll() throws IOException;

    /**
     * Reads a byte and applies the transformation
     *
     * @return
     * @throws IOException
     */
    default int readByte(Operand operand) throws IOException {
        return operand.apply(this.poll())[0];
    }

    /**
     * Reads a short (2 bytes) with the given {@link Endianness} and operand
     * @return
     * @throws IOException
     */
    default int readShort(Endianness endianness, Operand operand) throws IOException {
        checkArgument(endianness == Endianness.LITTLE_ENDIAN || endianness == Endianness.BIG_ENDIAN,"short can only be of LITTLE_ENDIAN or BIG_ENDIAN");
        return ByteBuffer.wrap(operand.apply(endianness.getLeastSignificantByte(), endianness.order(this.get(2)))).getShort();
    }

    /**
     * Reads a short (2 bytes) with the given {@link Endianness} and operand
     * @return
     * @throws IOException
     */
    default int readInt(Endianness endianness, Operand operand) throws IOException {
        return ByteBuffer.wrap(operand.apply(endianness.getLeastSignificantByte(), endianness.order(this.get(4)))).getInt();
    }

    /**
     * Reads a short (2 bytes) with the given {@link Endianness} and operand
     * @return
     * @throws IOException
     */
    default int readLong(Endianness endianness, Operand operand) throws IOException {
        checkArgument(endianness == Endianness.LITTLE_ENDIAN || endianness == Endianness.BIG_ENDIAN,"long can only be of LITTLE_ENDIAN or BIG_ENDIAN");
        return ByteBuffer.wrap(operand.apply(endianness.getLeastSignificantByte(), endianness.order(this.get(8)))).getInt();
    }

    default byte[] get(int length) throws IOException {
        byte[] data = new byte[length];
        for (int i = 0; i < length; i++)
            data[i] = this.poll();
        return data;
    }

}


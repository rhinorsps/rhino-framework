package org.rhino.rsps.net.stream;

import org.rhino.rsps.net.stream.mutator.Endianness;
import org.rhino.rsps.net.stream.mutator.Operand;

import java.io.IOException;
import java.nio.ByteBuffer;

import static com.google.common.base.Preconditions.checkArgument;

public interface InputStream extends Stream {

    /**
     * Reads an amount of data
     *
     * @return
     * @throws IOException
     */
    byte[] read(int length) throws IOException;

    /**
     * Reads an amount of data and orders bytes according to endianness
     *
     * @return
     * @throws IOException
     */
    default byte[] read(int length, Endianness endianness) throws IOException {
        return endianness.arrange(this.read(length));
    }

    /**
     * Reads a byte and applies the transformation
     *
     * @return
     * @throws IOException
     */
    default int readByte(Operand operand) throws IOException {
        return (byte) operand.apply(ByteBuffer.wrap(this.read(1)).get());
    }

    default int readByte() throws IOException {
        return this.readByte(DEFAULT_OPERAND);
    }

    default int readUnsignedByte(Operand operand) throws IOException {
        return this.readByte(operand) & 0xff;
    }

    default int readUnsignedByte() throws IOException {
        return this.readUnsignedByte(DEFAULT_OPERAND);
    }

    /**
     * Reads a short (2 bytes) with the given {@link Endianness} and mutator
     *
     * @return
     * @throws IOException
     */
    default int readShort(Endianness endianness, Operand operand) throws IOException {
        checkArgument(endianness == Endianness.LITTLE_ENDIAN || endianness == Endianness.BIG_ENDIAN, "short can only be of LITTLE_ENDIAN or BIG_ENDIAN");
        return (short) operand.apply(ByteBuffer.wrap(this.read(2, endianness)).getShort());
    }

    default int readShort(Endianness endianness) throws IOException {
        return this.readShort(endianness, DEFAULT_OPERAND);
    }

    default int readShort(Operand operand) throws IOException {
        return this.readShort(DEFAULT_ENDIANNESS, operand);
    }

    default int readShort() throws IOException {
        return this.readShort(DEFAULT_ENDIANNESS, DEFAULT_OPERAND);
    }

    default int readUnsignedShort(Endianness endianness, Operand operand) throws IOException {
        return this.readShort(endianness, operand) & 0xffff;
    }

    default int readUnsignedShort(Endianness endianness) throws IOException {
        return this.readUnsignedShort(endianness, DEFAULT_OPERAND);
    }

    default int readUnsignedShort(Operand operand) throws IOException {
        return this.readUnsignedShort(DEFAULT_ENDIANNESS, operand);
    }

    default int readUnsignedShort() throws IOException {
        return this.readUnsignedShort(DEFAULT_ENDIANNESS, DEFAULT_OPERAND);
    }

    /**
     * Mediums are ints with only 3 bytes. These should never be in a format other than
     * BIG_ENDIAN without an operand
     * @return
     * @throws IOException
     */
    default int readMedium() throws IOException {
        return ((ByteBuffer) ByteBuffer.allocate(4).put(read(3)).put((byte) 0).flip()).getInt() >> 8;
    }

    /**
     * Reads a short (2 bytes) with the given {@link Endianness} and mutator
     *
     * @return
     * @throws IOException
     */
    default int readInteger(Endianness endianness, Operand operand) throws IOException {
        return (int) operand.apply(ByteBuffer.wrap(this.read(4, endianness)).getInt());
    }

    default int readInteger(Endianness endianness) throws IOException {
        return this.readInteger(endianness, DEFAULT_OPERAND);
    }

    default int readInteger(Operand operand) throws IOException {
        return this.readInteger(DEFAULT_ENDIANNESS, operand);
    }

    default int readInteger() throws IOException {
        return this.readInteger(DEFAULT_ENDIANNESS, DEFAULT_OPERAND);
    }

    default long readUnsignedInteger(Endianness endianness, Operand operand) throws IOException {
        return this.readInteger(endianness, operand) & 0xffffffffL;
    }

    default long readUnsignedInteger(Endianness endianness) throws IOException {
        return this.readUnsignedInteger(endianness, DEFAULT_OPERAND);
    }

    default long readUnsignedInteger(Operand operand) throws IOException {
        return this.readUnsignedInteger(DEFAULT_ENDIANNESS, operand);
    }

    default long readUnsignedInteger() throws IOException {
        return this.readUnsignedInteger(DEFAULT_ENDIANNESS, DEFAULT_OPERAND);
    }

    /**
     * Reads a short (2 bytes) with the given {@link Endianness} and mutator
     *
     * @return
     * @throws IOException
     */
    default long readLong(Endianness endianness, Operand operand) throws IOException {
        return operand.apply(ByteBuffer.wrap(this.read(8, endianness)).getLong());
    }

    default long readLong(Endianness endianness) throws IOException {
        return this.readLong(endianness, DEFAULT_OPERAND);
    }

    default long readLong(Operand operand) throws IOException {
        return this.readLong(DEFAULT_ENDIANNESS, operand);
    }

    default long readLong() throws IOException {
        return this.readLong(DEFAULT_ENDIANNESS, DEFAULT_OPERAND);
    }

    /**
     * Reads a string, delimiter is \n
     * @return
     * @throws IOException
     */
    default String readString(char delimiter) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (byte b = (byte) readByte(); b != delimiter; b = (byte) readByte()) {
            builder.append((char) b);
        }
        return builder.toString();
    }

    default String readString() throws IOException {
        return readString('\n');
    }

}


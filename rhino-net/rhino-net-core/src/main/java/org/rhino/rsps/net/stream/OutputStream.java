package org.rhino.rsps.net.stream;

import org.rhino.rsps.net.stream.mutator.Endianness;
import org.rhino.rsps.net.stream.mutator.Operand;

import java.io.IOException;
import java.nio.ByteBuffer;

public interface OutputStream extends Stream {

    /**
     * Reads an amount of data
     *
     * @return
     * @throws IOException
     */
    OutputStream write(byte[] data) throws IOException;

    /**
     * Reads an amount of data and orders bytes according to endianness
     *
     * @return
     * @throws IOException
     */
    default OutputStream write(byte[] data, Endianness endianness) throws IOException {
        return this.write(endianness.arrange(data));
    }

    /**
     * Reads from an inputstream and writes the contents
     * @param in
     * @param length
     * @return
     */
    default OutputStream write(InputStream in, int length) throws IOException {
        return this.write(in.read(length));
    }

    /**
     * Helper method for write(in, in.available())
     * @param in
     * @return
     */
    default OutputStream write(InputStream in) throws IOException {
        return this.write(in.read(in.available()));
    }

    /**
     * Writes a byte with the given operand to the stream
     *
     * @param value
     * @param operand
     * @return
     * @throws IOException
     */
    default OutputStream writeByte(int value, Operand operand) throws IOException {
        return this.write(ByteBuffer.allocate(1).put((byte) operand.apply(value)).array());
    }

    default OutputStream writeByte(int value) throws IOException {
        return this.writeByte(value, DEFAULT_OPERAND);
    }

    /**
     * @param value
     * @param endianness
     * @param operand
     * @return
     * @throws IOException
     */
    default OutputStream writeShort(int value, Endianness endianness, Operand operand) throws IOException {
        return this.write(ByteBuffer.allocate(2).putShort((short) operand.apply(value)).array(), endianness);
    }

    default OutputStream writeShort(int value, Endianness endianness) throws IOException {
        return this.writeShort(value, endianness, DEFAULT_OPERAND);
    }

    default OutputStream writeShort(int value, Operand operand) throws IOException {
        return this.writeShort(value, DEFAULT_ENDIANNESS, operand);
    }

    default OutputStream writeShort(int value) throws IOException {
        return this.writeShort(value, DEFAULT_ENDIANNESS, DEFAULT_OPERAND);
    }

    /**
     * @param value
     * @return
     * @throws IOException
     */
    default OutputStream writeMedium(int value) throws IOException {
        return this.write(ByteBuffer.allocate(3).putShort((short) (value >> 8)).put((byte) (value & 0xff)).array());
    }

    /**
     * @param value
     * @return
     * @throws IOException
     */
    default OutputStream writeInteger(int value, Endianness endianness, Operand operand) throws IOException {
        return this.write(ByteBuffer.allocate(4).putInt((int) operand.apply(value)).array(), endianness);
    }

    default OutputStream writeInteger(int value, Endianness endianness) throws IOException {
        return this.writeInteger(value, endianness, DEFAULT_OPERAND);
    }

    default OutputStream writeInteger(int value, Operand operand) throws IOException {
        return this.writeInteger(value, DEFAULT_ENDIANNESS, operand);
    }

    default OutputStream writeInteger(int value) throws IOException {
        return this.writeInteger(value, DEFAULT_ENDIANNESS, DEFAULT_OPERAND);
    }

    /**
     * @param value
     * @return
     * @throws IOException
     */
    default OutputStream writeLong(long value, Endianness endianness, Operand operand) throws IOException {
        return this.write(ByteBuffer.allocate(8).putLong(operand.apply(value)).array(), endianness);
    }

    default OutputStream writeLong(long value, Endianness endianness) throws IOException {
        return this.writeLong(value, endianness, DEFAULT_OPERAND);
    }

    default OutputStream writeLong(long value, Operand operand) throws IOException {
        return this.writeLong(value, DEFAULT_ENDIANNESS, operand);
    }

    default OutputStream writeLong(long value) throws IOException {
        return this.writeLong(value, DEFAULT_ENDIANNESS, DEFAULT_OPERAND);
    }

}

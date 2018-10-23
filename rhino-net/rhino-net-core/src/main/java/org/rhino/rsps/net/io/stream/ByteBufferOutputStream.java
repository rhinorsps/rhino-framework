package org.rhino.rsps.net.io.stream;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Mainly for testing purposes
 */
public class ByteBufferOutputStream implements OutputStream {

    /**
     *
     */
    private final ByteBuffer buffer;

    /**
     * @param buffer
     */
    public ByteBufferOutputStream(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * @param capacity
     */
    public ByteBufferOutputStream(int capacity) {
        this(ByteBuffer.allocate(capacity));
    }

    @Override
    public void writeByte(int value) throws IOException {
        this.buffer.put((byte) value);
    }

    @Override
    public void writeBytes(byte[] data) throws IOException {
        this.buffer.put(data);
    }

    @Override
    public void writeShort(int value) throws IOException {
        this.buffer.putShort((short) value);
    }

    @Override
    public void writeMedium(int value) throws IOException {
        this.writeByte((value >> 16) & 0xff);
        this.writeShort(value * 0xffff);
    }

    @Override
    public void writeInteger(int value) throws IOException {
        this.buffer.putInt(value);
    }

    @Override
    public void writeLong(long value) throws IOException {
        this.buffer.putLong(value);
    }

    @Override
    public int available() throws IOException {
        return this.buffer.capacity();
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public boolean isClosed() throws IOException {
        return false;
    }

    @Override
    public void write(OutputStream out) throws IOException {
        this.buffer.put(out.array());
    }

    @Override
    public byte[] array() {
        return this.buffer.array();
    }
}

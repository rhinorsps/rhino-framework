package org.rhino.rsps.net.io.stream;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * For testing purposes
 *
 */
public class ByteBufferInputStream implements InputStream {

    /**
     *
     */
    private final ByteBuffer buffer;

    /**
     * @param buffer
     */
    public ByteBufferInputStream(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * @param capacity
     */
    public ByteBufferInputStream(int capacity) {
        this(ByteBuffer.allocate(capacity));
    }

    @Override
    public int readByte() throws IOException {
        return this.buffer.get();
    }

    @Override
    public int readShort() throws IOException {
        return this.buffer.getShort();
    }

    @Override
    public int readMedium() throws IOException {
        return (this.buffer.get() << 16) | this.readShort();
    }

    @Override
    public int readInteger() throws IOException {
        return this.buffer.getInt();
    }

    @Override
    public long readLong() throws IOException {
        return this.buffer.getLong();
    }

    @Override
    public byte[] readFully() throws IOException {
        return this.buffer.array();
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
}
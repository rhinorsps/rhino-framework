package org.rhino.rsps.net.stream;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public class ByteBufferInputStream implements InputStream {

    private final ByteBuffer buffer;

    public ByteBufferInputStream(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public ByteBufferInputStream(byte[] data) {
        this(ByteBuffer.wrap(data));
    }

    @Override
    public byte[] read(int length) throws IOException {
        if (available() < length) {
            throw new BufferUnderflowException();
        }
        byte[] bytes = new byte[length];
        this.buffer.get(bytes);
        return bytes;
    }

    @Override
    public InputStream readSlice(int length) throws IOException {
        return new ByteBufferInputStream(this.read(length));
    }

    @Override
    public int available() throws IOException {
        return buffer.capacity() - buffer.position();
    }

    @Override
    public void close() throws IOException {
        // no operation
    }

    @Override
    public boolean isClosed() throws IOException {
        return false;
    }

    @Override
    public int capacity() {
        return buffer.capacity();
    }

}
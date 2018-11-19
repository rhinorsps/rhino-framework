package org.rhino.rsps.net.stream;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

public class ByteBufferOutputStream implements OutputStream {

    private final ByteBuffer buffer;

    public ByteBufferOutputStream(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public ByteBufferOutputStream(byte[] data) {
        this.buffer = ByteBuffer.wrap(data);
    }

    @Override
    public OutputStream write(byte[] data) throws IOException {
        if (data.length > available()) {
            throw new BufferOverflowException();
        }
        this.buffer.put(data);
        return this;
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

    @Override
    public byte[] array() {
        return buffer.array();
    }
}

package org.rhino.rsps.net.stream;

import org.rhino.rsps.net.stream.InputStream;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public class ByteBufferInputStream implements InputStream {

    private final ByteBuffer buffer;

    public ByteBufferInputStream(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public ByteBufferInputStream(byte[] data) {
        this.buffer = ByteBuffer.wrap(data);
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

}

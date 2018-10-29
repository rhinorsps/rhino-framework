package org.rhino.rsps.net.netty.stream;

import io.netty.buffer.ByteBuf;
import org.rhino.rsps.net.stream.OutputStream;

import java.io.IOException;
import java.nio.BufferOverflowException;

public class ByteBufOutputStream implements OutputStream {

    /**
     *
     */
    private final ByteBuf byteBuf;

    public ByteBufOutputStream(ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    @Override
    public OutputStream write(byte[] data) throws IOException {
        if (data.length > available()) {
            throw new BufferOverflowException();
        }
        byteBuf.writeBytes(data);
        return this;
    }

    @Override
    public int available() throws IOException {
        return byteBuf.writableBytes();
    }

    @Override
    public void close() throws IOException {
        byteBuf.release();
    }

    @Override
    public boolean isClosed() throws IOException {
        return false;
    }

    @Override
    public int capacity() {
        return byteBuf.capacity();
    }

}

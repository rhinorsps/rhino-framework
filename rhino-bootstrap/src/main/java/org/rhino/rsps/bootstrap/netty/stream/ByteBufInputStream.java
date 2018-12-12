package org.rhino.rsps.bootstrap.netty.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.rhino.rsps.net.stream.InputStream;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.channels.ClosedChannelException;

public class ByteBufInputStream implements InputStream {

    /**
     *
     */
    private final ByteBuf byteBuf;

    public ByteBufInputStream(ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    public ByteBufInputStream(byte[] data) {
        this(Unpooled.wrappedBuffer(data));
    }

    @Override
    public byte[] read(int length) throws IOException {
        if (available() < length)
            throw new BufferUnderflowException();
        if (isClosed())
            throw new ClosedChannelException();
        byte[] bytes = new byte[length];
        this.byteBuf.readBytes(bytes);
        return bytes;
    }

    @Override
    public int available() throws IOException {
        return byteBuf.readableBytes();
    }

    @Override
    public void close() throws IOException {
        this.byteBuf.release();
    }

    @Override
    public int capacity() {
        return byteBuf.capacity();
    }

    @Override
    public boolean isClosed() throws IOException {
        return byteBuf.refCnt() <= 0;
    }

    @Override
    public byte[] array() {
        return byteBuf.array();
    }
}

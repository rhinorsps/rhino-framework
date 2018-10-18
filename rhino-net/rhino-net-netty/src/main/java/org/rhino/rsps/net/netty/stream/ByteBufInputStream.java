package org.rhino.rsps.net.netty.stream;

import io.netty.buffer.ByteBuf;
import org.rhino.rsps.net.io.stream.InputStream;

import java.io.IOException;

public class ByteBufInputStream implements InputStream {

    /**
     *
     */
    private final ByteBuf byteBuf;

    public ByteBufInputStream(ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    @Override
    public int readByte() throws IOException {
        return byteBuf.readByte();
    }

    @Override
    public int readShort() throws IOException {
        return byteBuf.readShort();
    }

    @Override
    public int readMedium() throws IOException {
        return byteBuf.readMedium();
    }

    @Override
    public int readInteger() throws IOException {
        return byteBuf.readInt();
    }

    @Override
    public long readLong() throws IOException {
        return byteBuf.readLong();
    }

    @Override
    public int available() throws IOException {
        return byteBuf.readableBytes();
    }

    @Override
    public void close() throws IOException {
        byteBuf.release();
    }

    @Override
    public boolean isClosed() throws IOException {
        return !byteBuf.isReadable() || byteBuf.refCnt() == 0;
    }

    @Override
    public byte[] readFully() throws IOException {
        return byteBuf.array();
    }
}

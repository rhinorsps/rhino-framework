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
        if (isClosed()) {
            throw new IOException("cannot read from a closed stream");
        }
        return byteBuf.readByte();
    }

    @Override
    public int readShort() throws IOException {
        if (isClosed()) {
            throw new IOException("cannot read from a closed stream");
        }
        return byteBuf.readShort();
    }

    @Override
    public int readMedium() throws IOException {
        if (isClosed()) {
            throw new IOException("cannot read from a closed stream");
        }
        return byteBuf.readMedium();
    }

    @Override
    public int readInteger() throws IOException {
        if (isClosed()) {
            throw new IOException("cannot read from a closed stream");
        }
        return byteBuf.readInt();
    }

    @Override
    public long readLong() throws IOException {
        if (isClosed()) {
            throw new IOException("cannot read from a closed stream");
        }
        return byteBuf.readLong();
    }

    @Override
    public int available() throws IOException {
        if (isClosed()) {
            throw new IOException("cannot read from a closed stream");
        }
        return byteBuf.readableBytes();
    }

    @Override
    public void close() throws IOException {
        if (isClosed()) {
            throw new IOException("stream is already closed");
        }
        byteBuf.release();
    }

    @Override
    public boolean isClosed() throws IOException {
        return !byteBuf.isReadable() || byteBuf.refCnt() == 0;
    }

    @Override
    public byte[] readFully() throws IOException {
        if (isClosed()) {
            throw new IOException("cannot read from a closed stream");
        }
        return byteBuf.array();
    }
}

package org.rhino.rsps.net.stream;

import java.io.IOException;
import java.nio.BufferOverflowException;

public class EmptyOutputStream implements OutputStream {

    @Override
    public OutputStream write(byte[] data) throws IOException {
        throw new BufferOverflowException();
    }

    @Override
    public byte[] array() {
        return new byte[0];
    }

    @Override
    public int available() throws IOException {
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public void close() throws IOException {
        // Do nothing
    }

    @Override
    public boolean isClosed() throws IOException {
        return true;
    }
}

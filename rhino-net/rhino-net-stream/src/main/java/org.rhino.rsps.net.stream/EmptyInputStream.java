package org.rhino.rsps.net.stream;

import java.io.IOException;

/**
 * Dummy inputstream that contains no data
 */
public class EmptyInputStream implements InputStream {

    @Override
    public byte[] read(int length) throws IOException {
        return new byte[0];
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

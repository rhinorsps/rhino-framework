package org.rhino.rsps.net.io;

import org.rhino.rsps.net.io.stream.ByteBufferInputStream;
import org.rhino.rsps.net.io.stream.InputStream;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Mainly for testing purposes
 */
public class ByteBufferInputStreamTest {

    private static final byte[] TEST_PAYLOAD = {
            1, 2, 3, 4, 5, 6, 7, 8
    };

    @Test
    public void testReadFully() throws IOException {
        try (InputStream inputStream = new ByteBufferInputStream(ByteBuffer.wrap(TEST_PAYLOAD))) {
            assertArrayEquals(TEST_PAYLOAD, inputStream.readFully());
        }
    }

    @Test
    public void testReadByte() throws IOException {
        try (InputStream inputStream = new ByteBufferInputStream(ByteBuffer.wrap(TEST_PAYLOAD))) {
            assertEquals(TEST_PAYLOAD[0], inputStream.readByte());
        }
    }

    @Test
    public void testAvailable() throws IOException {
        try (InputStream inputStream = new ByteBufferInputStream(ByteBuffer.wrap(TEST_PAYLOAD))) {
            assertEquals(inputStream.available(), TEST_PAYLOAD.length);
        }
    }

}

package org.rhino.rsps.net.netty.stream;

import io.netty.buffer.Unpooled;
import org.junit.Test;
import org.rhino.rsps.net.stream.InputStream;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ByteBufInputStreamTest {

    private static final byte[] TEST_PAYLOAD = {
            1, 2, 3, 4, 5, 6, 7, 8
    };

    @Test
    public void testReadFully() throws IOException {
        try (InputStream inputStream = new ByteBufInputStream(Unpooled.wrappedBuffer(TEST_PAYLOAD))) {
            assertArrayEquals(TEST_PAYLOAD, inputStream.read(TEST_PAYLOAD.length));
        }
    }

    @Test
    public void testReadByte() throws IOException {
        try (InputStream inputStream = new ByteBufInputStream(Unpooled.wrappedBuffer(TEST_PAYLOAD))) {
            assertEquals(TEST_PAYLOAD[0], inputStream.readByte());
        }
    }

    @Test(expected = IOException.class)
    public void testReadOnClosedStream() throws IOException {
        try (InputStream inputStream = new ByteBufInputStream(Unpooled.wrappedBuffer(TEST_PAYLOAD))) {
            inputStream.close();
            inputStream.readByte();
        }
    }

    @Test
    public void testAvailable() throws IOException {
        try (InputStream inputStream = new ByteBufInputStream(Unpooled.wrappedBuffer(TEST_PAYLOAD))) {
            assertEquals(inputStream.available(), TEST_PAYLOAD.length);
        }
    }

}

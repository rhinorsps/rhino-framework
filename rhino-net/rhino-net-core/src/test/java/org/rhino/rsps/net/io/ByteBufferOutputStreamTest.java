package org.rhino.rsps.net.io;

import org.junit.Test;
import org.rhino.rsps.net.io.stream.ByteBufferInputStream;
import org.rhino.rsps.net.io.stream.ByteBufferOutputStream;
import org.rhino.rsps.net.io.stream.InputStream;
import org.rhino.rsps.net.io.stream.OutputStream;

import java.io.IOException;
import java.nio.ByteBuffer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ByteBufferOutputStreamTest {

    private static final byte[] TEST_PAYLOAD = {
            1, 2, 3, 4, 5, 6, 7, 8
    };

    @Test
    public void testWriteBytes() throws IOException {
        try (OutputStream out = new ByteBufferOutputStream(TEST_PAYLOAD.length)) {
            out.writeBytes(TEST_PAYLOAD);
            assertArrayEquals(TEST_PAYLOAD, out.array());
        }
    }

    @Test
    public void testWriteByte() throws IOException {
        try (OutputStream out = new ByteBufferOutputStream(TEST_PAYLOAD.length)) {
            out.writeByte(TEST_PAYLOAD[0]);
            try (InputStream in = new ByteBufferInputStream(out)) {
                assertEquals(TEST_PAYLOAD[0], in.readByte());
            }
        }
    }

}

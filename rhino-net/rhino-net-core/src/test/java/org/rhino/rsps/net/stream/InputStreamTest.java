package org.rhino.rsps.net.stream;

import org.junit.Test;
import org.rhino.rsps.net.stream.mutator.Endianness;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Tests input stream methods, does NOT test endianness or operands
 */
public class InputStreamTest {

    private static final byte[] TEST_PAYLOAD = {
            -1, 2, 3, 4
    };

    @Test
    public void testAvailable() throws IOException {
        InputStream inputStream = new ByteBufferInputStream(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));
        assertEquals(4, inputStream.available());
        inputStream.readByte();
        assertEquals(3, inputStream.available());
        inputStream.readShort();
        assertEquals(1, inputStream.available());
    }

    @Test(expected = BufferUnderflowException.class)
    public void testBufferUnderflow() throws IOException {
        InputStream inputStream = new ByteBufferInputStream(Arrays.copyOf(TEST_PAYLOAD, 1));
        inputStream.readShort();
    }

    @Test
    public void testReadByte() throws IOException {
        InputStream inputStream = new ByteBufferInputStream(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));
        assertEquals(TEST_PAYLOAD[0], inputStream.readByte());
        assertEquals(3, inputStream.available());
    }

    @Test
    public void testReadUnsignedByte() throws IOException {
        InputStream inputStream = new ByteBufferInputStream(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));
        assertEquals(TEST_PAYLOAD[0] & 0xff, inputStream.readUnsignedByte());
        assertEquals(3, inputStream.available());
    }

    @Test
    public void testReadShort() throws IOException {
        InputStream inputStream = new ByteBufferInputStream(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));
        assertEquals((TEST_PAYLOAD[0] << 8) | TEST_PAYLOAD[1], inputStream.readShort());
        assertEquals(2, inputStream.available());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReadShortIllegalEndian() throws IOException {
        InputStream inputStream = new ByteBufferInputStream(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));
        inputStream.readShort(Endianness.MIDDLE_ENDIAN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReadShortIllegalEndian2() throws IOException {
        InputStream inputStream = new ByteBufferInputStream(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));
        inputStream.readShort(Endianness.INVERSE_MIDDLE_ENDIAN);
    }

    @Test
    public void testReadInteger() throws IOException {
        InputStream inputStream = new ByteBufferInputStream(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));
        assertEquals(ByteBuffer.wrap(TEST_PAYLOAD).getInt(), inputStream.readInteger());
        assertEquals(0, inputStream.available());
    }

    @Test
    public void testReadMedium() throws IOException {
        InputStream inputStream = new ByteBufferInputStream(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));
        assertEquals(((TEST_PAYLOAD[0] << 16) | (TEST_PAYLOAD[1] << 8)) | TEST_PAYLOAD[2], inputStream.readMedium());
        assertEquals(1, inputStream.available());
    }

}

package org.rhino.rsps.net.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

import static org.junit.Assert.assertEquals;

public class OutputStreamTest {

    private static final int TEST_BYTE = 69;
    private static final int TEST_SHORT = -12000;
    private static final int TEST_MEDIUM = 80000;
    private static final int TEST_INTEGER = -200000000;
    private static final long TEST_LONG = 4000000000L;

    @Test
    public void testWriteByte() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(1);
        try (OutputStream out = new ByteBufferOutputStream(buffer)) {
            out.writeByte(TEST_BYTE);
            assertEquals(TEST_BYTE, buffer.get(0));
            assertEquals(0, out.available());
        }
    }

    @Test
    public void testWriteShort() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        try (OutputStream out = new ByteBufferOutputStream(buffer)) {
            out.writeShort(TEST_SHORT);

            assertEquals(TEST_SHORT >> 8, buffer.get(0));
            assertEquals((byte) (TEST_SHORT & 0xff), buffer.get(1));
            assertEquals(0, out.available());
        }
    }

    @Test
    public void testWriteMedium() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(3);
        try (OutputStream out = new ByteBufferOutputStream(buffer)) {
            out.writeMedium(TEST_MEDIUM);

            assertEquals((TEST_MEDIUM >> 16) & 0xff, buffer.get(0) & 0xff);
            assertEquals((TEST_MEDIUM >> 8) & 0xff, buffer.get(1) & 0xff);
            assertEquals(TEST_MEDIUM & 0xff, buffer.get(2) & 0xff);
            assertEquals(0, out.available());
        }
    }

    @Test
    public void testWriteInteger() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        try (OutputStream out = new ByteBufferOutputStream(buffer)) {
            out.writeInteger(TEST_INTEGER);

            assertEquals((TEST_INTEGER >> 24) & 0xff, buffer.get(0) & 0xff);
            assertEquals((TEST_INTEGER >> 16) & 0xff, buffer.get(1) & 0xff);
            assertEquals((TEST_INTEGER >> 8) & 0xff, buffer.get(2) & 0xff);
            assertEquals(TEST_INTEGER & 0xff, buffer.get(3) & 0xff);
            assertEquals(0, out.available());
        }
    }

    @Test
    public void testWriteLong() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        try (OutputStream out = new ByteBufferOutputStream(buffer)) {
            out.writeLong(TEST_LONG);

            assertEquals((TEST_LONG >> 56) & 0xff, buffer.get(0) & 0xff);
            assertEquals((TEST_LONG >> 48) & 0xff, buffer.get(1) & 0xff);
            assertEquals((TEST_LONG >> 40) & 0xff, buffer.get(2) & 0xff);
            assertEquals((TEST_LONG >> 32) & 0xff, buffer.get(3) & 0xff);
            assertEquals((TEST_LONG >> 24) & 0xff, buffer.get(4) & 0xff);
            assertEquals((TEST_LONG >> 16) & 0xff, buffer.get(5) & 0xff);
            assertEquals((TEST_LONG >> 8) & 0xff, buffer.get(6) & 0xff);
            assertEquals(TEST_LONG & 0xff, buffer.get(7) & 0xff);
            assertEquals(0, out.available());
        }
    }

    @Test(expected = BufferOverflowException.class)
    public void testBufferOverFlow() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1);
        try (OutputStream out = new ByteBufferOutputStream(buffer)) {
            out.writeShort(15);
        }
    }

}

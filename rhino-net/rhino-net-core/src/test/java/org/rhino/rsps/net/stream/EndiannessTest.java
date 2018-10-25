package org.rhino.rsps.net.stream;

import org.junit.Test;
import org.rhino.rsps.net.stream.mutator.Endianness;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class EndiannessTest {

    /**
     * The test payload
     */
    private static final byte[] TEST_PAYLOAD = {
            1, 1, 2, 4
    };

    @Test
    public void testBigEndian() {
        byte[] test = Endianness.BIG_ENDIAN.arrange(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));

        assertEquals(TEST_PAYLOAD[0], test[0]);
        assertEquals(TEST_PAYLOAD[1], test[1]);
        assertEquals(TEST_PAYLOAD[2], test[2]);
        assertEquals(TEST_PAYLOAD[3], test[3]);
    }

    @Test
    public void testLittleEndian() {
        byte[] test = Endianness.LITTLE_ENDIAN.arrange(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));

        assertEquals(TEST_PAYLOAD[3], test[0]);
        assertEquals(TEST_PAYLOAD[2], test[1]);
        assertEquals(TEST_PAYLOAD[1], test[2]);
        assertEquals(TEST_PAYLOAD[0], test[3]);
    }

    @Test
    public void testMiddleEndian() {
        byte[] test = Endianness.MIDDLE_ENDIAN.arrange(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));

        assertEquals(TEST_PAYLOAD[2], test[0]);
        assertEquals(TEST_PAYLOAD[3], test[1]);
        assertEquals(TEST_PAYLOAD[0], test[2]);
        assertEquals(TEST_PAYLOAD[1], test[3]);
    }

    @Test
    public void testMiddleEndianReverse() {
        byte[] test = Endianness.INVERSE_MIDDLE_ENDIAN.arrange(Arrays.copyOf(TEST_PAYLOAD, TEST_PAYLOAD.length));

        assertEquals(TEST_PAYLOAD[1], test[0]);
        assertEquals(TEST_PAYLOAD[0], test[1]);
        assertEquals(TEST_PAYLOAD[3], test[2]);
        assertEquals(TEST_PAYLOAD[2], test[3]);
    }

}

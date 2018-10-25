package org.rhino.rsps.net.stream;

import org.junit.Test;
import org.rhino.rsps.net.stream.mutator.Operand;

import static org.junit.Assert.assertEquals;

/**
 * TODO
 */
public class OperandTest {

    private static final byte TEST_SUBJECT_BYTE = Byte.MIN_VALUE;
    private static final short TEST_SUBJECT_SHORT = Short.MIN_VALUE;

    @Test
    public void testOperandNoOp() {
        assertEquals(TEST_SUBJECT_BYTE, Operand.NO_OP.apply(TEST_SUBJECT_BYTE));
    }

    @Test
    public void testOperandAdditiveByte() {
        assertEquals((byte) (128 + TEST_SUBJECT_BYTE), (byte) Operand.ADDITIVE.apply(TEST_SUBJECT_BYTE));
    }

    @Test
    public void testOperandSubtractByte() {
        assertEquals((byte) (128 - TEST_SUBJECT_BYTE), (byte) Operand.SUBTRACT.apply(TEST_SUBJECT_BYTE));
    }

    @Test
    public void testOperandNoOpShort() {
        long value = Operand.NO_OP.apply(TEST_SUBJECT_SHORT);

        assertEquals(TEST_SUBJECT_SHORT, value);
    }

    @Test
    public void testOperandNegateByte() {
        assertEquals((byte) -TEST_SUBJECT_BYTE, (byte) Operand.NEGATE.apply(TEST_SUBJECT_BYTE));
    }

    @Test
    public void testOperandAdditiveShort() {
        long value = Operand.ADDITIVE.apply(TEST_SUBJECT_SHORT);

        assertEquals((128 + TEST_SUBJECT_SHORT) & 0xff, value & 0xff);
        assertEquals(TEST_SUBJECT_SHORT >> 8, value >> 8);
    }

    @Test
    public void testOperandNegateShort() {
        long value = Operand.NEGATE.apply(TEST_SUBJECT_SHORT);

        assertEquals((-TEST_SUBJECT_SHORT) & 0xff, value & 0xff);
        assertEquals(TEST_SUBJECT_SHORT >> 8, value >> 8);
    }

    @Test
    public void testOperandSubtractShort() {
        long value = Operand.SUBTRACT.apply(TEST_SUBJECT_SHORT);

        assertEquals((128 - TEST_SUBJECT_SHORT) & 0xff, value & 0xff);
        assertEquals(TEST_SUBJECT_SHORT >> 8, value >> 8);
    }

}

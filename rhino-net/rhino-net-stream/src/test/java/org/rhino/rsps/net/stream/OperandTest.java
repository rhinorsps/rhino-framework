package org.rhino.rsps.net.stream;

import org.junit.Test;
import org.rhino.rsps.net.stream.mutator.Operand;

import static org.junit.Assert.assertEquals;

/**
 * TODO
 */
public class OperandTest {

    private static final int TEST_SUBJECT = 696969;

    @Test
    public void testOperandNoOp() {
        assertEquals(TEST_SUBJECT, Operand.NO_OP.apply(TEST_SUBJECT));
    }

}

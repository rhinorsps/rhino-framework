package org.rhino.rsps.net.io.message.impl;

public class FixedSizeMessageTemplate extends DefaultMessageTemplate {

    private final int expectedLength;

    public FixedSizeMessageTemplate(int opcode, int expectedLength) {
        super(opcode, Type.FIXED_SIZE);
        this.expectedLength = expectedLength;
    }

    public int getExpectedLength() {
        return expectedLength;
    }
}

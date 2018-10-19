package org.rhino.rsps.net.io.message.impl;

public class FixedSizeMessageTemplate extends DefaultMessageTemplate {

    public FixedSizeMessageTemplate(int opcode, int expectedLength) {
        super(opcode, expectedLength, Type.FIXED_SIZE);
    }

}

package org.rhino.rsps.net.io.message.impl;

import org.rhino.rsps.net.io.message.MessageTemplate;

/**
 * An abstract message template
 */
public class DefaultMessageTemplate implements MessageTemplate {

    /**
     * The expected opcode of the message
     */
    private final int opcode;

    /**
     * The expected length of the message
     */
    private final int length;

    /**
     * The predefined length of the message
     */
    private final Type type;

    public DefaultMessageTemplate(int opcode, int length, Type type) {
        this.opcode = opcode;
        this.length = length;
        this.type = type;
    }

    @Override
    public int getExpectedOpcode() {
        return opcode;
    }

    @Override
    public int getExpectedLength() {
        return length;
    }

    @Override
    public Type getType() {
        return type;
    }
}

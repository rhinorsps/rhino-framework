package org.rhino.rsps.net.io.message.impl;

import org.rhino.rsps.net.io.message.MessageTemplate;

/**
 * An abstract message template
 */
abstract class AbstractMessageTemplate implements MessageTemplate {

    /**
     * The expected opcode of the message
     */
    private final int opcode;

    public AbstractMessageTemplate(int opcode) {
        this.opcode = opcode;
    }

    @Override
    public int getExpectedOpcode() {
        return opcode;
    }
}

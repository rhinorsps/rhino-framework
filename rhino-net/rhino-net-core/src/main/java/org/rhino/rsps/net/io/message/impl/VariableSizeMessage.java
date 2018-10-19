package org.rhino.rsps.net.io.message.impl;

/**
 * A template for a message that has a predefined payload length
 *
 * FIXME: This is bad, make fixed size and variable size 2 different message template types
 */
public class VariableSizeMessage extends DefaultMessageTemplate {

    public VariableSizeMessage(int opcode, Type type) {
        super(opcode, -1, type);
    }

}

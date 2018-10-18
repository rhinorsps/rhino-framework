package org.rhino.rsps.net.io.message.impl;

import org.rhino.rsps.net.io.stream.InputStream;

/**
 * A template for a message that has a predefined payload length
 *
 * FIXME: This is bad, make fixed size and variable size 2 different message template types
 */
public class DefaultMessageTemplate extends AbstractMessageTemplate {

    /**
     * The predefined length of the message
     */
    private final Type type;

    public DefaultMessageTemplate(int opcode, Type type) {
        super(opcode);
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}

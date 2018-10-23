package org.rhino.rsps.net.io.message.serialize.annotation;

import org.rhino.rsps.net.io.message.MessageTemplate;

public @interface MessageDefinition {

    /**
     * The opcode of the message
     *
     * @return
     */
    int[] opcode();

    /**
     * The message length
     *
     * @return
     */
    MessageTemplate.Type length() default MessageTemplate.Type.FIXED_SIZE;

    /**
     * The attributes of the message
     *
     * @return
     */
    Attribute[] attributes() default {};

}

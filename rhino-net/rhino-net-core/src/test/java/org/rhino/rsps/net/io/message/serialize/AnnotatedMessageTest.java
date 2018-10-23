package org.rhino.rsps.net.io.message.serialize;

import org.rhino.rsps.net.io.message.serialize.annotation.Attribute;
import org.rhino.rsps.net.io.message.serialize.annotation.MessageDefinition;

@MessageDefinition(opcode = 15, attributes = {
        @Attribute(field = "test", type = DataType.BYTE)
})
public class AnnotatedMessageTest {

    /**
     * The test value, of type byte
     */
    private String test;

}

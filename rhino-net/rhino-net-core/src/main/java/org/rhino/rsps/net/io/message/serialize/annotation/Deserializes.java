package org.rhino.rsps.net.io.message.serialize.annotation;

public @interface Deserializes {

    /**
     * The opcode of the message this deserializer listens to
     *
     * @return
     */
    int value();

}

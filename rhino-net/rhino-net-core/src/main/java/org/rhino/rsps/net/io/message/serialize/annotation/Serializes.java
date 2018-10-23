package org.rhino.rsps.net.io.message.serialize.annotation;

public @interface Serializes {

    /**
     * The class that this serializer listens for
     *
     * @return
     */
    Class<?> value();

}

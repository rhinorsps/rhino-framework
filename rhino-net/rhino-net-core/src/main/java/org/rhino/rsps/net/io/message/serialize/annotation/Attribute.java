package org.rhino.rsps.net.io.message.serialize.annotation;

import org.rhino.rsps.net.io.message.serialize.DataType;

public @interface Attribute {

    /**
     * The name of the field
     *
     * @return
     */
    String field();

    /**
     * The type of the field
     *
     * @return
     */
    DataType type();

}

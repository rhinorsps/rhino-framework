package org.rhino.rsps.net.io.message.serialize.reflection.pipeline;

import org.rhino.rsps.net.io.message.Message;

public class MessageSerializerPipeline<T> extends Pipeline<T, Message> {

    @Override
    public Message prepare(T input) throws Exception {
        return null;
    }

    @Override
    public void destroy(T input, Message output) throws Exception {
        // do nothing
    }

}

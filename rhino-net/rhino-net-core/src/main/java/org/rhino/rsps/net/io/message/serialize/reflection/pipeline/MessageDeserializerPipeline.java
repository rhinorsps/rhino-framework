package org.rhino.rsps.net.io.message.serialize.reflection.pipeline;

import org.rhino.rsps.net.io.message.Message;
import org.rhino.rsps.net.io.message.serialize.annotation.MessageDefinition;

public class MessageDeserializerPipeline<T> extends Pipeline<Message, T> {

    /**
     *
     */
    private final Class<T> type;

    public MessageDeserializerPipeline(Class<T> type) {
        this.type = type;
    }

    @Override
    public T prepare(Message input) throws Exception {
        return type.newInstance();
    }

    @Override
    public void destroy(Message input, Object output) throws Exception {
        input.getPayload().close();
    }

}

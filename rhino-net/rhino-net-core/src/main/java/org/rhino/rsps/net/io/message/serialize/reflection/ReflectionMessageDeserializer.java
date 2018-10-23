package org.rhino.rsps.net.io.message.serialize.reflection;

import org.rhino.rsps.net.io.message.Message;
import org.rhino.rsps.net.io.message.serialize.MessageDeserializer;
import org.rhino.rsps.net.io.message.serialize.reflection.pipeline.MessageDeserializerPipeline;

public class ReflectionMessageDeserializer<T> implements MessageDeserializer<T> {

    /**
     *
     */
    private final MessageDeserializerPipeline pipeline;

    public ReflectionMessageDeserializer(MessageDeserializerPipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public T deserialize(Message message) throws Exception {
        return null;
    }

}

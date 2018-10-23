package org.rhino.rsps.net.io.message.serialize.reflection;

import org.rhino.rsps.net.io.message.Message;
import org.rhino.rsps.net.io.message.MessageTemplate;
import org.rhino.rsps.net.io.message.serialize.MessageSerializer;
import org.rhino.rsps.net.io.stream.OutputStream;
import org.rhino.rsps.net.io.stream.OutputStreamFactory;

public class ReflectionMessageSerializer implements MessageSerializer {

    /**
     * The message template
     */
    private final MessageTemplate template;

    /**
     * The pipeline that serializes the message
     */
    private final MessageSerializerPipeline pipeline;

    /**
     * Creates output streams
     */
    private final OutputStreamFactory outputStreamFactory;

    public ReflectionMessageSerializer(MessageTemplate template, MessageSerializerPipeline pipeline, OutputStreamFactory outputStreamFactory) {
        this.template = template;
        this.pipeline = pipeline;
        this.outputStreamFactory = outputStreamFactory;
    }

    @Override
    public Message serialize(Object object) throws Exception {
        OutputStream body = this.outputStreamFactory.create(template.getExpectedLength());



        return null;
    }

}

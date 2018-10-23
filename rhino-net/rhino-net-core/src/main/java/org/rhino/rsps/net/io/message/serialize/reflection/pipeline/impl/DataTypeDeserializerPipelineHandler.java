package org.rhino.rsps.net.io.message.serialize.reflection.pipeline.impl;

import org.rhino.rsps.net.io.message.Message;
import org.rhino.rsps.net.io.message.serialize.DataType;
import org.rhino.rsps.net.io.message.serialize.DataTypes;
import org.rhino.rsps.net.io.message.serialize.reflection.pipeline.PipelineHandler;

import java.lang.reflect.Field;

public class DataTypeDeserializerPipelineHandler implements PipelineHandler<Message, Object> {

    private final Field field;

    private final DataType dataType;

    public DataTypeDeserializerPipelineHandler(Field field, DataType dataType) {
        this.field = field;
        this.dataType = dataType;
    }

    @Override
    public boolean accept(Message input) {
        return true;
    }

    @Override
    public Object handle(Message input, Object partial) throws Exception {
        Object data = DataTypes.read(dataType, input.getPayload());
        field.set(partial, data);
        return data;
    }

}

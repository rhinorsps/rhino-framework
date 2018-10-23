package org.rhino.rsps.net.io.message.serialize.reflection.pipeline;

public interface PipelineHandler<I, O> {

    boolean accept(I input);

    O handle(I input, Object partial) throws Exception;

}

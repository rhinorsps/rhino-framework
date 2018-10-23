package org.rhino.rsps.net.io.message.serialize.reflection.pipeline;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

abstract class Pipeline<I, O> {

    private final Queue<PipelineHandler<I, O>> handlers = new LinkedList<>();

    /**
     *
     * @param input
     * @return
     * @throws Exception
     */
    public O handle(I input) throws Exception {
        O partial = prepare(input);

        for (Iterator<PipelineHandler<I, O>> iterator = handlers.iterator(); iterator.hasNext(); ) {
            PipelineHandler<I, O> handler = iterator.next();

            if (!handler.accept(input))
                continue;

            partial = handler.handle(input, partial);
        }

        destroy(input, partial);
        return partial;
    }

    /**
     * Creates the incomplete object
     *
     * @param input
     * @throws Exception
     */
    public abstract O prepare(I input) throws Exception;

    /**
     *
     * @param input
     * @param output
     * @throws Exception
     */
    public abstract void destroy(I input, O output) throws Exception;

    /**
     * Gets the next pipeline handler
     * @return
     */
    public PipelineHandler<I, O> next() {
        return handlers.poll();
    }

    /**
     * Validates the pipeline
     *
     * @return
     */
    public boolean validate() {
        return true;
    }

    /**
     *
     * @param handler
     * @return
     */
    public Pipeline<I, O> add(PipelineHandler<I, O> handler) {
        handlers.add(handler);
        return this;
    }

}

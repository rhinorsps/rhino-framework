package org.rhino.rsps.core.processor;

public interface Processor {

    void queue(ProcessorTask task);

    void process();

}

package org.rhino.rsps.net.stream.provider;

import org.rhino.rsps.net.stream.OutputStream;

public interface OutputStreamProvider<BUFFER> extends StreamProvider<BUFFER, OutputStream> {

    /**
     *
     * @param capacity
     * @return
     */
    OutputStream create(int capacity);

}

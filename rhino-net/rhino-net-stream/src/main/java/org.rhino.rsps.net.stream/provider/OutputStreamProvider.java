package org.rhino.rsps.net.stream.provider;

import org.rhino.rsps.net.stream.OutputStream;

public interface OutputStreamProvider<BUFFER, T extends OutputStream> extends StreamProvider<BUFFER, T> {

    /**
     *
     * @param capacity
     * @return
     */
    T create(int capacity);

}

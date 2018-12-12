package org.rhino.rsps.net.stream.provider;

import org.rhino.rsps.net.stream.InputStream;

public interface InputStreamProvider<BUFFER, T extends InputStream> extends StreamProvider<BUFFER, T> {

    /**
     *
     * @return
     */
    default T wrap(byte[] bytes) {
        return this.wrap(bytes, 0, bytes.length);
    }

    /**
     *
     * @return
     */
    T wrap(byte[] bytes, int offset, int length);

}

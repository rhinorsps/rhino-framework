package org.rhino.rsps.net.stream.provider;

import org.rhino.rsps.net.stream.InputStream;

public interface InputStreamProvider<BUFFER> extends StreamProvider<BUFFER, InputStream> {

    /**
     *
     * @return
     */
    default InputStream wrap(byte[] bytes) {
        return this.wrap(bytes, 0, bytes.length);
    }

    /**
     *
     * @return
     */
    InputStream wrap(byte[] bytes, int offset, int length);

}

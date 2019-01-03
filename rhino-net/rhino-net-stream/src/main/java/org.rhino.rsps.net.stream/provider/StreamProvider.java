package org.rhino.rsps.net.stream.provider;

import org.rhino.rsps.net.stream.ByteStream;

interface StreamProvider<BUFFER, T extends ByteStream> {

    /**
     *
     * @param buffer
     * @return
     */
    T provide(BUFFER buffer);

}

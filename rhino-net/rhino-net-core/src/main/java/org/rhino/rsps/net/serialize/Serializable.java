package org.rhino.rsps.net.serialize;

import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.provider.OutputStreamProvider;

public interface Serializable {

    /**
     * Serializes the class to an input stream
     *
     * @param provider
     * @return
     * @throws Exception
     */
    InputStream serialize(OutputStreamProvider<?> provider) throws Exception;

}

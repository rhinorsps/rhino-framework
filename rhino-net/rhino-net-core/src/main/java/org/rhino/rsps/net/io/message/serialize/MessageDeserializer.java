package org.rhino.rsps.net.io.message.serialize;

import org.rhino.rsps.net.io.message.Message;

public interface MessageDeserializer<T> {

    /**
     *
     * @param message
     * @return
     * @throws Exception
     */
    T deserialize(Message message) throws Exception;

}

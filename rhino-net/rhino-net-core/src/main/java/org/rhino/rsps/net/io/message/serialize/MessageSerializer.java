package org.rhino.rsps.net.io.message.serialize;


import org.rhino.rsps.net.io.message.Message;

/**
 *
 * @param <T>
 */
public interface MessageSerializer<T> {

    /**
     *
     * @param object
     * @return
     * @throws Exception
     */
    Message serialize(T object) throws Exception;

}

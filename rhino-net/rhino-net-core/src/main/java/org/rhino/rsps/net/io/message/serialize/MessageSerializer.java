package org.rhino.rsps.net.io.message.serialize;


import org.rhino.rsps.net.io.message.Message;

/**
 *
 * @param <T>
 */
public interface MessageSerializer {

    /**
     *
     * @param object
     * @return
     * @throws Exception
     */
    Message serialize(Object object) throws Exception;

}

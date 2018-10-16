package org.rhino.rsps.net;

import org.rhino.rsps.net.session.Session;

public interface Controller {

    /**
     * Register the channel to the controller
     *
     * @param channel
     * @throws Exception
     */
    Session push(Session channel) throws Exception;

    /**
     * Drops the channel from this controller
     *
     * @param channel
     * @throws Exception
     */
    void drop(Session channel) throws Exception;

}

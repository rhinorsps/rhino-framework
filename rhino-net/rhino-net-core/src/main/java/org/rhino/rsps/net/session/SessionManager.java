package org.rhino.rsps.net.session;

/**
 * Manages the active sessions.
 */
public interface SessionManager {

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

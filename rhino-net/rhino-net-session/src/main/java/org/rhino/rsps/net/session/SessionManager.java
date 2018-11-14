package org.rhino.rsps.net.session;

public interface SessionManager {

    /**
     *
     * @param session
     */
    Session register(Session session);

    /**
     *
     * @param session
     */
    Session remove(Session session);

}

package org.rhino.rsps.net.session;

import org.rhino.rsps.net.io.Message;
import org.rhino.rsps.net.io.concurrent.Promise;

import java.io.IOException;

public interface Session {

    /**
     * Gets the session context
     * 
     * @return
     */
    SessionContext getSessionContext();

    /**
     *
     * @return
     */
    Promise<Session> read(Object message) throws IOException;

    /**
     *
     * @param object
     * @return
     * @throws IOException
     */
    Promise<Session> write(Object object) throws IOException;

    /**
     *
     * @return
     */
    Promise<Session> disconnect();

}

package org.rhino.rsps.net.session;

import org.rhino.rsps.net.io.Message;
import org.rhino.rsps.net.io.concurrent.Promise;

import java.io.IOException;

public interface Session {

    /**
     *
     * @return
     */
    Promise<?> read(Message message) throws IOException;

    /**
     *
     * @param object
     * @return
     * @throws IOException
     */
    Promise<?> write(Object object) throws IOException;

    /**
     *
     * @return
     */
    Promise<Session> disconnect();

}

package org.rhino.rsps.net;

import org.rhino.rsps.net.io.message.MessageTemplateRepository;
import org.rhino.rsps.net.session.SessionContext;

import java.io.IOException;
import java.net.InetSocketAddress;

public interface Controller {

    /**
     *
     * @param address
     * @throws Exception
     */
    void serve(InetSocketAddress address) throws Exception;

    /**
     * Shuts the service down
     *
     * @throws Exception
     */
    void shutdown() throws Exception;

    /**
     *
     * @param context
     * @return
     * @throws IOException
     */
    MessageTemplateRepository getTemplateRepository(SessionContext context) throws IOException;

}

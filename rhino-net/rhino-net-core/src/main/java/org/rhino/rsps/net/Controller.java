package org.rhino.rsps.net;

import org.rhino.rsps.net.io.message.MessageTemplateRepository;
import org.rhino.rsps.net.session.SessionContext;

import java.io.IOException;

public interface Controller {

    /**
     *
     * @param context
     * @return
     * @throws IOException
     */
    MessageTemplateRepository getTemplateRepository(SessionContext context) throws IOException;

}

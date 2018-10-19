package org.rhino.rsps.net;

import org.rhino.rsps.net.io.message.MessageTemplateRepository;
import org.rhino.rsps.net.session.SessionContext;

import java.io.IOException;

public abstract class AbstractController implements Controller {

    @Override
    public MessageTemplateRepository getTemplateRepository(SessionContext context) throws IOException {
        return null;
    }

}

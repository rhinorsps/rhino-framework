package org.rhino.rsps.bootstrap.netty;

import io.netty.util.AttributeKey;
import org.rhino.rsps.core.session.Session;
import org.rhino.rsps.core.session.SessionContext;

public interface Attributes {

    AttributeKey<Session> SESSION = AttributeKey.valueOf(Session.class, "instance");
    AttributeKey<Session> SESSION_CONTEXT = AttributeKey.valueOf(SessionContext.class, "instance");

}

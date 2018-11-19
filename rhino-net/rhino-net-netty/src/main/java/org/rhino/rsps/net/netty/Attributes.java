package org.rhino.rsps.net.netty;

import io.netty.util.AttributeKey;
import org.rhino.rsps.net.session.Session;
import org.rhino.rsps.net.session.SessionContext;

public final class Attributes {

    public static final AttributeKey<Session> SESSION = AttributeKey.valueOf(Session.class, "instance");
    public static final AttributeKey<Session> SESSION_CONTEXT = AttributeKey.valueOf(SessionContext.class, "instance");

    private Attributes() {}

}

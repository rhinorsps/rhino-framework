package org.rhino.rsps.net.netty;

import io.netty.util.AttributeKey;
import org.rhino.rsps.core.session.Session;
import org.rhino.rsps.core.session.SessionContext;

public interface Attributes {

    AttributeKey<Session> SESSION = AttributeKey.valueOf(Session.class, "session");
    AttributeKey<Long> SERVER_KEY = AttributeKey.valueOf(Long.class, "server_key");

}

package org.rhino.rsps.net.netty.util;

import io.netty.util.AttributeKey;
import org.rhino.rsps.net.session.Session;

public final class Attributes {

    public static final AttributeKey<Session> SESSION_ATTRIBUTE_KEY = AttributeKey.valueOf(Session.class, "instance");

    private Attributes() {}

}

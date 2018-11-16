package org.rhino.rsps.net.netty;

import io.netty.util.AttributeKey;

public final class Attributes {

    public static final AttributeKey<Session> SESSION_ATTRIBUTE_KEY = AttributeKey.valueOf(Session.class, "instance");

    private Attributes() {}

}

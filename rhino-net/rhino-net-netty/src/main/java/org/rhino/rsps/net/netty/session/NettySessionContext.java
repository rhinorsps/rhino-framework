package org.rhino.rsps.net.netty.session;

import org.rhino.rsps.core.session.AbstractSessionContext;
import org.rhino.rsps.core.session.SessionManager;
import org.rhino.rsps.net.netty.stream.ByteBufInputStream;
import org.rhino.rsps.net.netty.stream.ByteBufOutputStream;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

import java.net.InetSocketAddress;

public class NettySessionContext extends AbstractSessionContext {

    public NettySessionContext(InetSocketAddress address, SessionManager<?> manager) {
        super(address, manager);
    }

    /**
     * Creates an output stream with an initial capacity
     *
     * @return
     */
    public OutputStream createOutputStream(int capacity) {
        return new ByteBufOutputStream(capacity);
    }

    /**
     * Creates an input stream from a byte array
     *
     * @param data
     * @return
     */
    public InputStream createInputStream(byte[] data) {
        return new ByteBufInputStream(data);
    }

}

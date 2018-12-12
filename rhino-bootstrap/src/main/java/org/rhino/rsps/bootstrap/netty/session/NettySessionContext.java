package org.rhino.rsps.bootstrap.netty.session;

import org.rhino.rsps.bootstrap.netty.stream.ByteBufInputStreamProvider;
import org.rhino.rsps.bootstrap.netty.stream.ByteBufOutputStreamProvider;
import org.rhino.rsps.core.session.AbstractSessionContext;
import org.rhino.rsps.core.session.SessionManager;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

import java.net.InetSocketAddress;

public class NettySessionContext extends AbstractSessionContext {

    /**
     * The input stream provider
     */
    private final ByteBufInputStreamProvider inputStreamProvider = new ByteBufInputStreamProvider();

    /**
     * The outputstream provider
     */
    private final ByteBufOutputStreamProvider outputStreamProvider = new ByteBufOutputStreamProvider();

    public NettySessionContext(InetSocketAddress address, SessionManager<?> manager) {
        super(address, manager);
    }

    /**
     * Creates an output stream with an initial capacity
     *
     * @return
     */
    public OutputStream createOutputStream(int capacity) {
        return this.outputStreamProvider.create(capacity);
    }

    /**
     * Creates an input stream from a byte array
     *
     * @param data
     * @return
     */
    public InputStream createInputStream(byte[] data) {
        return this.inputStreamProvider.wrap(data);
    }

}

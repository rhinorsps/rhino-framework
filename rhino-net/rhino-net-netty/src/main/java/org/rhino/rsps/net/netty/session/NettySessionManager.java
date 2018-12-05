package org.rhino.rsps.net.netty.session;

import io.netty.channel.socket.SocketChannel;
import org.rhino.rsps.core.session.AbstractSessionManager;
import org.rhino.rsps.core.session.Session;

import java.net.InetSocketAddress;

/**
 * Implementation of the session manager
 */
public class NettySessionManager extends AbstractSessionManager<SocketChannel> {

    @Override
    public Session create(InetSocketAddress inetSocketAddress, SocketChannel socketChannel) throws Exception {
        return new NettySession(new NettySessionContext(inetSocketAddress, this), socketChannel);
    }

}

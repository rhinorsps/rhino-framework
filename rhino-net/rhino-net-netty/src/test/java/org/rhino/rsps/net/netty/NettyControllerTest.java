package org.rhino.rsps.net.netty;


import org.junit.Test;
import org.rhino.rsps.net.Controller;

import java.net.InetSocketAddress;

public class NettyControllerTest {

    private static final int port = 43599;
    private static final String host = "localhost";

    @Test
    public void testNettyController() throws Exception {
        Controller nettyController = new NettyController();
        nettyController.serve(InetSocketAddress.createUnresolved(host, port));
        nettyController.shutdown();
    }

}

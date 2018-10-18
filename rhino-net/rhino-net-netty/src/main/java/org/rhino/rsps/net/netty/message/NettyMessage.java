package org.rhino.rsps.net.netty.message;

import org.rhino.rsps.net.io.message.Message;
import org.rhino.rsps.net.io.stream.InputStream;
import org.rhino.rsps.net.netty.stream.ByteBufInputStream;

import java.io.IOException;

public class NettyMessage implements Message {

    /**
     * The opcode of the message
     */
    private final int opcode;

    /**
     *
     */
    private final ByteBufInputStream inputStream;

    public NettyMessage(int opcode, ByteBufInputStream inputStream) {
        this.opcode = opcode;
        this.inputStream = inputStream;
    }

    @Override
    public InputStream getPayload() throws IOException {
        return inputStream;
    }

    @Override
    public int getOpcode() throws IOException {
        return opcode;
    }

}

package org.rhino.rsps.net.netty.message;

import io.netty.buffer.ByteBuf;
import org.rhino.rsps.net.io.message.MessageTemplate;
import org.rhino.rsps.net.io.stream.InputStream;
import org.rhino.rsps.net.io.stream.OutputStream;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class NettyMessageWriter {

    private final ByteBuf buffer;

    private NettyMessageWriter(ByteBuf buffer) {
        this.buffer = buffer;
    }

    public static NettyMessageWriter create(ByteBuf buffer) {
        return new NettyMessageWriter(buffer);
    }

    public NettyMessageWriter opcode(int opcode) {
        checkArgument(opcode > -1, "opcode cannot be negative");
        this.buffer.writeByte(opcode);
        return this;
    }

    public NettyMessageWriter length(MessageTemplate.Type type, int length) {
        checkArgument(length >= 0, "negatice length");
        checkNotNull(type, "missing type");

        switch (type) {
            case VARIABLE_BYTE:
                buffer.writeByte(length);
                break;
            case VARIABLE_SHORT:
                buffer.writeShort(length);
                break;
        }
        return this;
    }

    public NettyMessageWriter payload(InputStream stream) throws IOException {
        checkArgument(!stream.isClosed(), "unreadable stream");
        buffer.writeBytes(stream.readFully());
        return this;
    }

    public ByteBuf complete() {
        return buffer.markReaderIndex().retain();
    }

}

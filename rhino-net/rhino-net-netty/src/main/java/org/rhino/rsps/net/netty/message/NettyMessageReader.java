package org.rhino.rsps.net.netty.message;

import io.netty.buffer.ByteBuf;
import org.rhino.rsps.net.io.message.Message;
import org.rhino.rsps.net.io.message.MessageTemplate;
import org.rhino.rsps.net.io.message.impl.FixedSizeMessageTemplate;
import org.rhino.rsps.net.netty.stream.ByteBufInputStream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class NettyMessageReader {

    private final ByteBuf buffer;

    private int opcode = -1;
    private int length = -1;

    private NettyMessageReader(ByteBuf buffer) {
        this.buffer = buffer;
    }

    /**
     * Creates a new netty message builder
     * @return
     */
    public static NettyMessageReader create(ByteBuf buffer) {
        return new NettyMessageReader(buffer);
    }

    /**
     * opcode
     * @return
     */
    public NettyMessageReader opcode(int expectedOpcode) {
        checkNotNull(buffer);
        checkArgument(buffer.getUnsignedByte(0) == expectedOpcode, "opcode mismatch");
        this.opcode = buffer.readUnsignedByte();
        return this;
    }

    public NettyMessageReader length(MessageTemplate.Type type, int expectedLength) {
        checkNotNull(buffer);

        switch (type) {
            case FIXED_SIZE:
                length = expectedLength;
                break;
            case VARIABLE_BYTE:
                checkState(buffer.readableBytes() >= 1, "cannot read length");
                length = buffer.readUnsignedByte();
                break;
            case VARIABLE_SHORT:
                checkState(buffer.readableBytes() >= 2, "cannot read length");
                length = buffer.readUnsignedShort();
                break;
        }
        checkState(buffer.readableBytes() >= length, "buffer underflow");
        return this;
    }

    public Message complete() {
        checkState(opcode != -1, "opcode cannot be negative");
        checkState(length != -1, "length cannot be negative");
        checkState(buffer.readableBytes() >= length, "buffer capacity < length", buffer.readableBytes(), length);
        checkNotNull(buffer);

        return new NettyMessage(opcode, new ByteBufInputStream(buffer.readBytes(length).asReadOnly()));
    }

}

package org.rhino.rsps.net.netty.message;

import io.netty.buffer.ByteBuf;
import org.rhino.rsps.net.io.message.Message;
import org.rhino.rsps.net.io.message.MessageTemplate;
import org.rhino.rsps.net.io.message.impl.FixedSizeMessageTemplate;
import org.rhino.rsps.net.netty.stream.ByteBufInputStream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class NettyMessageReader {

    /**
     * The template
     */
    private final MessageTemplate template;

    private int opcode = -1;
    private int length = -1;

    private ByteBufInputStream inputStream;

    /**
     * Cannot instantiate from outside this class
     *
     * @param template
     */
    private NettyMessageReader(MessageTemplate template) {
        this.template = template;
    }

    /**
     * Creates a new netty message builder
     * @param template
     * @return
     */
    public static NettyMessageReader fromTemplate(MessageTemplate template) {
        return new NettyMessageReader(template).opcode(template.getExpectedOpcode());
    }

    /**
     * opcode
     * @param opcode
     * @return
     */
    public NettyMessageReader opcode(int opcode) {
        checkArgument(opcode != template.getExpectedOpcode(), "opcode mismatch");
        this.opcode = opcode;
        return this;
    }

    public NettyMessageReader length(ByteBuf buffer) {
        checkNotNull(buffer);
        switch (template.getType()) {
            case FIXED_SIZE:
                checkArgument(template instanceof FixedSizeMessageTemplate, "found message with fixed length, but template was not of type FixedSizeMessage");
                length = FixedSizeMessageTemplate.class.cast(template).getExpectedLength();
                break;
            case VARIABLE_BYTE:
                checkArgument(buffer.readableBytes() >= 1, "cannot read length");
                length = buffer.readUnsignedByte();
                break;
            case VARIABLE_SHORT:
                checkArgument(buffer.readableBytes() >= 2, "cannot read length");
                length = buffer.readUnsignedShort();
                break;
        }
        return this;
    }

    public NettyMessageReader payload(ByteBuf buf) {
        checkArgument(length != -1, "length cannot be negative");
        checkArgument(buf.readableBytes() >= length, "buffer capacity < length");
        this.inputStream = new ByteBufInputStream(buf.readBytes(length).asReadOnly());
        return this;
    }

    public Message complete() {
        checkArgument(opcode != -1, "opcode cannot be negative");
        checkArgument(length != -1, "length cannot be negative");
        checkNotNull(inputStream, "inputStream cannot be null");

        return new NettyMessage(opcode, inputStream);
    }

}

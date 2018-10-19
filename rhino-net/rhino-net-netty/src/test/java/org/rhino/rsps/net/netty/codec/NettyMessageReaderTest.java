package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;
import org.rhino.rsps.net.io.message.Message;
import org.rhino.rsps.net.io.message.MessageTemplate;
import org.rhino.rsps.net.io.message.impl.VariableSizeMessage;
import org.rhino.rsps.net.io.message.impl.FixedSizeMessageTemplate;
import org.rhino.rsps.net.netty.message.NettyMessageReader;
import org.rhino.rsps.net.netty.message.NettyMessageWriter;
import org.rhino.rsps.net.netty.stream.ByteBufInputStream;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class NettyMessageReaderTest {

    private static final int TEST_OPCODE = 15;
    private static final byte[] TEST_PAYLOAD = new byte[]{
            1, 2, 3, 4, 5
    };

    private final MessageTemplate fixedSizeTemplate = new FixedSizeMessageTemplate(
            TEST_OPCODE, TEST_PAYLOAD.length);

    private final MessageTemplate variableByteTemplate = new VariableSizeMessage(
            TEST_OPCODE, MessageTemplate.Type.VARIABLE_BYTE);

    private final MessageTemplate variableShortTemplate = new VariableSizeMessage(
            TEST_OPCODE, MessageTemplate.Type.VARIABLE_SHORT);

    @Test
    public void testMessageReaderFixedSize() throws IOException {
        /**
         * Create the test packet
         */
        ByteBuf testPacket = NettyMessageWriter.create(Unpooled.buffer())
                .opcode(TEST_OPCODE)
                .length(MessageTemplate.Type.FIXED_SIZE, 0)
                .payload(new ByteBufInputStream(Unpooled.wrappedBuffer(TEST_PAYLOAD)))
                .complete();

        Message message = NettyMessageReader.create(testPacket)
                .opcode(TEST_OPCODE)
                .length(fixedSizeTemplate.getType(), TEST_PAYLOAD.length)
                .complete();

        assertEquals(TEST_OPCODE, message.getOpcode());
        assertEquals(TEST_PAYLOAD.length, message.getPayload().available());
    }

    @Test
    public void testMessageReaderVariableSizeByte() throws IOException {
        /**
         * Create the test packet
         */
        ByteBuf testPacket = NettyMessageWriter.create(Unpooled.buffer())
                .opcode(TEST_OPCODE)
                .length(MessageTemplate.Type.VARIABLE_BYTE, TEST_PAYLOAD.length)
                .payload(new ByteBufInputStream(Unpooled.wrappedBuffer(TEST_PAYLOAD)))
                .complete();

        Message message = NettyMessageReader.create(testPacket)
                .opcode(TEST_OPCODE)
                .length(variableByteTemplate.getType(), -1)
                .complete();

        assertEquals(TEST_OPCODE, message.getOpcode());
        assertEquals(TEST_PAYLOAD.length, message.getPayload().available());
    }

    @Test
    public void testMessageReaderVariableSizeShort() throws IOException {
        /**
         * Create the test packet
         */
        ByteBuf testPacket = NettyMessageWriter.create(Unpooled.buffer())
                .opcode(TEST_OPCODE)
                .length(MessageTemplate.Type.VARIABLE_SHORT, TEST_PAYLOAD.length)
                .payload(new ByteBufInputStream(Unpooled.wrappedBuffer(TEST_PAYLOAD)))
                .complete();

        Message message = NettyMessageReader.create(testPacket)
                .opcode(TEST_OPCODE)
                .length(variableShortTemplate.getType(), -1)
                .complete();

        assertEquals(TEST_OPCODE, message.getOpcode());
        assertEquals(TEST_PAYLOAD.length, message.getPayload().available());
    }

}

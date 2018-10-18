package org.rhino.rsps.net.netty.codec;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;
import org.rhino.rsps.net.io.message.MessageTemplate;
import org.rhino.rsps.net.netty.message.NettyMessageWriter;
import org.rhino.rsps.net.netty.stream.ByteBufInputStream;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class NettyMessageWriterTest {

    private static final int TEST_OPCODE = 15;
    private static final byte[] TEST_PAYLOAD = new byte[]{
            1, 2, 3, 4, 5
    };

    @Test
    public void testWriterWithFixedSize() throws IOException {
        ByteBuf testPayload = Unpooled.wrappedBuffer(TEST_PAYLOAD);

        ByteBuf output = NettyMessageWriter.create(Unpooled.buffer())
                .opcode(TEST_OPCODE)
                .length(MessageTemplate.Type.FIXED_SIZE, 0)
                .payload(new ByteBufInputStream(testPayload))
                .complete();

        assertEquals(TEST_OPCODE, output.getByte(0));
        assertEquals(1 + testPayload.capacity(), output.readableBytes());
    }

    @Test
    public void testWriterWithVariableSizeByte() throws IOException {
        ByteBuf testPayload = Unpooled.wrappedBuffer(TEST_PAYLOAD);

        ByteBuf output = NettyMessageWriter.create(Unpooled.buffer())
                .opcode(TEST_OPCODE)
                .length(MessageTemplate.Type.VARIABLE_BYTE, testPayload.readableBytes())
                .payload(new ByteBufInputStream(testPayload))
                .complete();

        assertEquals(TEST_OPCODE, output.getByte(0));
        assertEquals(testPayload.readableBytes(), output.getByte(1));
        assertEquals(2 + testPayload.capacity(), output.readableBytes());
    }

    @Test
    public void testWriterWithVariableSizeShort() throws IOException {
        ByteBuf testPayload = Unpooled.wrappedBuffer(TEST_PAYLOAD);

        ByteBuf output = NettyMessageWriter.create(Unpooled.buffer())
                .opcode(TEST_OPCODE)
                .length(MessageTemplate.Type.VARIABLE_SHORT, testPayload.readableBytes())
                .payload(new ByteBufInputStream(testPayload))
                .complete();

        assertEquals(TEST_OPCODE, output.getByte(0));
        assertEquals(testPayload.readableBytes(), output.getShort(1));
        assertEquals(3 + testPayload.capacity(), output.readableBytes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalPayload() throws IOException {
        ByteBufInputStream testPayload = new ByteBufInputStream(Unpooled.wrappedBuffer(TEST_PAYLOAD));
        testPayload.close();
        NettyMessageWriter.create(Unpooled.buffer()).payload(testPayload);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeOpcode() {
        NettyMessageWriter.create(Unpooled.buffer()).opcode(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLength() {
        NettyMessageWriter.create(Unpooled.buffer()).length(MessageTemplate.Type.VARIABLE_BYTE, -1);
    }

}

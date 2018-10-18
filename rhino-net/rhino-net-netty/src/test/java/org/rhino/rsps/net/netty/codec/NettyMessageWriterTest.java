package org.rhino.rsps.net.netty.codec;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Before;
import org.junit.Test;
import org.rhino.rsps.net.Controller;
import org.rhino.rsps.net.io.message.MessageTemplate;
import org.rhino.rsps.net.netty.message.NettyMessageWriter;
import org.rhino.rsps.net.netty.stream.ByteBufInputStream;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RS2GameCodecTest {

    private static final int TEST_OPCODE = 15;

    @Test
    public void testDecode() throws IOException {
        ByteBuf testPayload = Unpooled.wrappedBuffer(new byte[] {
                1, 2, 3, 4, 5
        });

        ByteBuf output = NettyMessageWriter.create(Unpooled.buffer())
                .opcode(TEST_OPCODE)
                .length(MessageTemplate.Type.FIXED_SIZE, 0)
                .payload(new ByteBufInputStream(testPayload))
                .complete();

        assertEquals(TEST_OPCODE, output.getByte(0));
        assertEquals(1 + testPayload.capacity(), output.readableBytes());
    }

    @Test
    public void testDecodeWithVariableLengthByte() throws IOException {
        ByteBuf testPayload = Unpooled.wrappedBuffer(new byte[] {
                1, 2, 3, 4, 5
        });

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
    public void testDecodeWithVariableLengthShort() throws IOException {
        ByteBuf testPayload = Unpooled.wrappedBuffer(new byte[] {
                1, 2, 3, 4, 5
        });

        ByteBuf output = NettyMessageWriter.create(Unpooled.buffer())
                .opcode(TEST_OPCODE)
                .length(MessageTemplate.Type.VARIABLE_SHORT, testPayload.readableBytes())
                .payload(new ByteBufInputStream(testPayload))
                .complete();

        assertEquals(TEST_OPCODE, output.getByte(0));
        assertEquals(testPayload.readableBytes(), output.getShort(1));
        assertEquals(3 + testPayload.capacity(), output.readableBytes());
    }


}

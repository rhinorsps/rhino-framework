package org.rhino.rsps.bootstrap.netty.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.rhino.rsps.net.stream.provider.InputStreamProvider;

/**
 * reservation for future implementations that use pooled buffers if necessary
 */
public class ByteBufInputStreamProvider implements InputStreamProvider<ByteBuf, ByteBufInputStream> {

    @Override
    public ByteBufInputStream create(ByteBuf byteBuf) {
        return new ByteBufInputStream(byteBuf);
    }

    @Override
    public ByteBufInputStream wrap(byte[] bytes, int offset, int length) {
        return this.create(Unpooled.wrappedBuffer(bytes, offset, length));
    }

}

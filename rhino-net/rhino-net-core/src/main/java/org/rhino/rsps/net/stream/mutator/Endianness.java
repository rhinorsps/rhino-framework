package org.rhino.rsps.net.stream.mutator;

import com.google.common.primitives.Bytes;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.function.Function;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Indicates the order of the bytes in a packet
 */
public enum Endianness {

    /**
     * The most significant byte (MSB) value, 0Ah, is at the lowest address.
     * The other bytes follow in decreasing order of significance.
     * This is akin to left-to-right reading in hexadecimal order.
     */
    BIG_ENDIAN(Function.identity()),

    /**
     * The least significant byte (LSB) value, 0Dh, is at the lowest address.
     * The other bytes follow in increasing order of significance. This is akin to right-to-left
     * reading in hexadecimal order.
     */
    LITTLE_ENDIAN(Endianness::littleEndian),

    /**
     * Byte ordering is offset by 2, so b[0,1,2,3] becomes b[2,3,0,1], this should only be called
     * for integers (4 bytes)
     */
    MIDDLE_ENDIAN(Endianness::middleEndian),

    /**
     * Reverse of above b[0,1,2,3] becomes b[1,0,3,2]
     */
    INVERSE_MIDDLE_ENDIAN(LITTLE_ENDIAN.mutator.andThen(MIDDLE_ENDIAN.mutator::apply));

    /**
     * The function that is applied to the byte order
     */
    private final Function<byte[], byte[]> mutator;

    /**
     * @param mutator
     */
    Endianness(Function<byte[], byte[]> mutator) {
        this.mutator = mutator;
    }

    /**
     * Puts the data in its correct order
     *
     * @param data
     * @return
     */
    public byte[] arrange(byte[] data) {
        return mutator.apply(data);
    }

    /**
     * Reverses the order of the bytes
     *
     * @param bytes
     * @return
     */
    private static byte[] littleEndian(byte[] bytes) {
        Bytes.reverse(bytes);
        return bytes;
    }

    /**
     * [0,1,2,3] -> [2,3,0,1] in a 4-byte integer, basically swap the first 2 and the second 2 bytes,
     * or shift the array to the left/right by 2
     *
     * @param bytes
     * @return
     */
    private static byte[] middleEndian(byte[] bytes) {
        checkArgument(bytes.length == 4, "middle endian only available to 4-byte integers");
        return ByteBuffer.allocate(4)
                .put(bytes, 2, 2)
                .put(bytes, 0, 2).array();
    }

}
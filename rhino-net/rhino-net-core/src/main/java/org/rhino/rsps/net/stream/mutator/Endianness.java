package org.rhino.rsps.net.stream.mutator;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.function.Function;
import java.util.function.UnaryOperator;

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
     * Reverse of above
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
        for (int i = 0; i < bytes.length / 2; i++) {
            byte temp = bytes[i];
            bytes[i] = bytes[bytes.length - 1 - i];
            bytes[bytes.length - 1 - i] = temp;
        }
        return bytes;
    }

    /**
     * shifts bytes 2 to the right
     *
     * @param bytes
     * @return
     */
    private static byte[] middleEndian(byte[] bytes) {
        byte[] output = new byte[bytes.length];
        for (int index = 0; index < bytes.length; index++) {
            output[index] = bytes[(index + 2) % bytes.length];
        }
        return output;
    }

}
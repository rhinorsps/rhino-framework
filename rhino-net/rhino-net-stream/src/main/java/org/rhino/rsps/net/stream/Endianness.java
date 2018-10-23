package org.rhino.rsps.net.stream;

import java.util.function.Function;

/**
 * Indicates the order of the bytes in a packet
 */
public enum Endianness {

    /**
     * The most significant byte (MSB) value, 0Ah, is at the lowest address.
     * The other bytes follow in decreasing order of significance.
     * This is akin to left-to-right reading in hexadecimal order.
     */
    BIG_ENDIAN,

    /**
     * Numerous other orderings, generically called middle-endian or mixed-endian, are possible.
     */
    MIDDLE_ENDIAN,

    /**
     * Numerous other orderings, generically called middle-endian or mixed-endian, are possible.
     */
    INVERSE_MIDDLE_ENDIAN,

    /**
     * The least significant byte (LSB) value, 0Dh, is at the lowest address.
     * The other bytes follow in increasing order of significance. This is akin to right-to-left
     * reading in hexadecimal order.
     */
    LITTLE_ENDIAN;

}
package org.rhino.rsps.net.packet;

/**
 * Information about how the size is determined depending on the packet
 * <p>
 * The size can be known beforehand or it can be given in the packet itself. There
 * are also multiple ways to store this size so it's important to have the packets
 * sorted by their type correctly.
 */
public enum MetaData {

    /**
     * the length of of the packet is the amount of bytes received
     */
    AVAILABLE,

    /**
     * The length of the packet is known beforehand and is of a fixed length
     */
    FIXED,

    /**
     * The length is sent as a byte (8-bit)
     */
    SMALL,

    /**
     * The length is sent as a short (16-bit)
     */
    MEDIUM,

    /**
     * The length is sent as an integer (32-bit)
     */
    BIG;

}
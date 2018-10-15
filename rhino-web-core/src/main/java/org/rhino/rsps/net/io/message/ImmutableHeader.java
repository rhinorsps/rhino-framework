package org.rhino.rsps.net.io.message;

/**
 * A header whose state cannot be changed after it has been created
 */
public class ImmutableHeader implements Header {

    /**
     * The length of the payload
     */
    private final int length;

    /**
     * The opcode of the payload
     */
    private final int opcode;

    /**
     *
     * @param length
     * @param opcode
     */
    public ImmutableHeader(int length, int opcode) {
        this.length = length;
        this.opcode = opcode;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getOpcode() {
        return opcode;
    }

}

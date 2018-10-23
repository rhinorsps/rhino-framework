package org.rhino.rsps.net.stream;

import java.util.function.Function;

/**
 * Transforms single bytes of data to the correct type
 */
public enum Operand {

    /**
     * No operation required
     */
    NO_OP(b -> b),

    /**
     * Adds 128 to the byte's value
     */
    ADDITION(b -> b + 128),

    /**
     * Subtracts 128 from the byte's value
     */
    SUBTRACT(b -> 128 - b),

    /**
     * Inverses the byte's value
     */
    INVERSE(b -> -b);

    /**
     * The transformation function
     */
    private final Function<Integer, Integer> function;

    /**
     * constr
     * @param function
     */
    Operand(Function<Integer, Integer> function) {
        this.function = function;
    }

    /**
     * Applies the function to the integer
     *
     * @param value
     * @return
     */
    public byte[] apply(int position, byte... value) {
        int result = function.apply((int) value[position]);
        value[position] = (byte) result;
        return value;
    }

}

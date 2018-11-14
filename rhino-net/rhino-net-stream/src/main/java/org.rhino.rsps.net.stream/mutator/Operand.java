package org.rhino.rsps.net.stream.mutator;

import java.util.function.Function;

/**
 * Transforms single bytes of data to the correct type
 */
public enum Operand {

    /**
     * No operation required
     */
    NO_OP(Function.identity()),

    /**
     * Adds 128 to the byte's value (Type A)
     */
    ADDITIVE(b -> b + 128),

    /**
     * Subtracts 128 from the byte's value (Type B)
     */
    SUBTRACT(b -> 128 - b),

    /**
     * Inverses the byte's value (Type C)
     */
    NEGATE(b -> -b);

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
     * Applies the function to the integer. It's always the least significant byte that has the operation
     * done to it. This means that in a long, short, or int, the lowest 8-bits will hold the transformation
     */
    public long apply(long value) {
        long lsb = function.apply((int) (value & 0xff));
        value >>= 8;
        return (value << 8) | lsb;
    }

}

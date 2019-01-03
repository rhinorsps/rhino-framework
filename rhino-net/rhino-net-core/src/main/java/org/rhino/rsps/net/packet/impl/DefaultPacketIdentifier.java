package org.rhino.rsps.net.packet.impl;

import org.rhino.rsps.net.packet.GameState;
import org.rhino.rsps.net.packet.PacketIdentifier;

public class DefaultPacketIdentifier implements PacketIdentifier {

    /**
     * The opcode of the packet
     */
    private final int opcode;

    /**
     * The game state
     */
    private final GameState state;

    public DefaultPacketIdentifier(int opcode, GameState state) {
        this.opcode = opcode;
        this.state = state;
    }

    @Override
    public int hashCode() {
        int prime = 37;

        // The hashcode is the same when the opcode and state are equal, multiplied by random prime for uniqueness
        return prime * ((state.ordinal() << 8) | opcode);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof DefaultPacketIdentifier) {
            DefaultPacketIdentifier identifier = (DefaultPacketIdentifier) other;

            // identifiers are the same when the opcode and state are the same
            return identifier.opcode == this.opcode && identifier.state == this.state;
        }
        return false;
    }

    @Override
    public GameState getState() {
        return this.state;
    }

    @Override
    public int getOpcode() {
        return this.opcode;
    }

}

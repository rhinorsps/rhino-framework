package org.rhino.rsps.net.packet.definition;

public interface PacketDefinitionRepository {

    /**
     *
     * @return
     */
    PacketDefinition get(int opcode, SubRepository subRepository);

    /**
     *
     */
    enum SubRepository {
        UPSTREAM, DOWNSTREAM;
    }

}

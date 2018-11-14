package org.rhino.rsps.net.packet.definition;

import org.rhino.rsps.net.session.SessionContext;

public interface PacketDefinitionRepository {

    /**
     *
     * @return
     */
    PacketDefinition get(int opcode, SessionContext context, SubRepository subRepository);

    /**
     *
     */
    enum SubRepository {
        IN, OUT;
    }

}

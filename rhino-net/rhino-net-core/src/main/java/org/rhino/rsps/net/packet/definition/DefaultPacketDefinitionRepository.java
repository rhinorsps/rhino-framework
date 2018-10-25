package org.rhino.rsps.net.packet.definition;

import org.rhino.rsps.net.session.SessionContext;

public class DefaultPacketDefinitionRepository implements PacketDefinitionRepository {



    @Override
    public PacketDefinition get(int opcode, SessionContext context, SubRepository subRepository) {
        return null;
    }

}

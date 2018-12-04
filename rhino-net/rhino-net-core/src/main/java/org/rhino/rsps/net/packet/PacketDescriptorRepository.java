package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.session.SessionContext;

public interface PacketDescriptorRepository {

    /**
     * Gets the descriptor for the given opcode
     *
     * @param opcode
     * @return
     */
    PacketDescriptor getInputStreamDescriptor(int opcode);

    /**
     * Gets the descriptor for the given model class
     *
     * @param model
     * @return
     */
    PacketDescriptor getOutputStreamDescriptor(Class<?> model);

}

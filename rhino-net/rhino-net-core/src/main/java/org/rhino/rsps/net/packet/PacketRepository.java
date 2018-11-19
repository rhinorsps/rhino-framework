package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.session.SessionContext;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

public interface PacketRepository {

    /**
     * Gets the handler for the descriptor
     * @param descriptor
     * @return
     */
    PacketHandler<Packet, Object> getInputStreamHandler(PacketDescriptor descriptor, SessionContext context);

    /**
     * Gets the handler for the descriptor
     *
     * @param descriptor
     * @return
     */
    PacketHandler<Object, Packet> getOutputStreamHandler(PacketDescriptor descriptor, SessionContext context);

    /**
     * Gets the descriptor for the given opcode
     *
     * @param opcode
     * @return
     */
    PacketDescriptor getInputStreamDescriptor(int opcode, SessionContext context);

    /**
     * Gets the descriptor for the given model class
     *
     * @param model
     * @return
     */
    PacketDescriptor getOutputStreamDescriptor(Class<?> model, SessionContext context);

}

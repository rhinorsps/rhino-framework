package org.rhino.rsps.net.packet.handler;

import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDescriptor;
import org.rhino.rsps.net.packet.PacketHandler;
import org.rhino.rsps.net.session.SessionContext;
import org.rhino.rsps.net.stream.ByteBufferOutputStream;
import org.rhino.rsps.net.stream.OutputStream;

public interface OutputStreamPacketHandler extends PacketHandler<Object, Packet> {

}

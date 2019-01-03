package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.rhino.rsps.core.session.Session;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.netty.Attributes;
import org.rhino.rsps.net.netty.stream.ByteBufInputStreamProvider;
import org.rhino.rsps.net.packet.ConnectionState;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDefinition;
import org.rhino.rsps.net.packet.PacketIdentifier;
import org.rhino.rsps.net.packet.impl.ReadOnlyPacket;
import org.rhino.rsps.net.packet.impl.DefaultPacketIdentifier;
import org.rhino.rsps.net.stream.EmptyInputStream;
import org.rhino.rsps.net.stream.provider.InputStreamProvider;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class PacketDecoder extends ReplayingDecoder<ConnectionState> {

    /**
     * The RNG
     */
    private static final SecureRandom random = new SecureRandom();

    /**
     *
     */
    private final InputStreamProvider<ByteBuf> inputStreamProvider = new ByteBufInputStreamProvider();

    /**
     * The server context in which this decoder runs
     */
    private final ServerContext serverContext;

    /**
     * Sets the default authentication state
     *
     * @param serverContext
     */
    public PacketDecoder(ServerContext serverContext) {
        super(ConnectionState.HANDSHAKE);
        this.serverContext = serverContext;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Session<?> session = ctx.channel().attr(Attributes.SESSION).get();

        switch (state()) {
            case HANDSHAKE:
                out.add(decodeHandshake(session, ctx, in));
                break;

            case AUTHENTICATION:
                out.add(decodeAuthentication(session, ctx, in));
                break;

            case GAME:
                out.add(decodeGamePacket(session, ctx, in));
                break;
        }
    }

    /**
     * Decodes the handshake of the RS2 login protocol
     * <p>
     * Currently the only known handshake message footprint is as follows
     * <p>
     * +-----------+
     * | Opcode    |
     * +-----------+
     *
     * @param ctx
     * @param in
     */
    private Packet decodeHandshake(Session<?> session, ChannelHandlerContext ctx, ByteBuf in) throws IOException {
        PacketIdentifier identifier = new DefaultPacketIdentifier(in.readUnsignedByte(), state());

        checkpoint(ConnectionState.AUTHENTICATION);

        return new ReadOnlyPacket(identifier, new EmptyInputStream());
    }

    /**
     * Decodes the authentication of the RS2 login protocol
     * <p>
     * +-------------------------+
     * | Opcode                  |
     * | length                  |
     * +-------------------------+
     * | client_version_minor    |
     * | client_version_major    |
     * | encrypted_packet_length |
     * +-------------------------+
     * | secure_id               | \
     * | client_isaac_seed       |  |
     * | server_isaac_seed       |  | - Encrypted with RSA
     * | username                |  |
     * | password                | /
     * +-------------------------+
     *
     * @param ctx
     * @param in
     */
    private Packet decodeAuthentication(Session<?> session, ChannelHandlerContext ctx, ByteBuf in) throws IOException {
        PacketIdentifier identifier = new DefaultPacketIdentifier(in.readUnsignedByte(), state());

        checkpoint(ConnectionState.GAME);

        return new ReadOnlyPacket(identifier, this.inputStreamProvider.provide(in.readBytes(in.readUnsignedByte())));
    }

    /**
     * There are currently 2 known ways in which the game packets can be received.
     * <p>
     * When the size of the packet is a fixed length and is known beforehand:
     * <p>
     * +-------------------+
     * | opcode (byte)     |
     * +-------------------+
     * | payload           |
     * +-------------------+
     * <p>
     * When the size of the packet is received with size varying on the contents, the size is
     * then sent in the header of the message (this can be a short or a byte)
     * <p>
     * +-------------------+
     * | opcode            |
     * | length            |
     * +-------------------+
     * | payload           |
     * +-------------------+
     * <p>
     * This length indicator can be either a byte or a short.
     * The type of packet should be known beforehand and is looked up in the repository, it will indicate if it
     * has a fixed length or if it is given, will indicate if the packet is read during the authentication state, etc.
     * <p>
     * This should be configured in the server context (or with annotations if one uses the bootstrap)
     * <p>
     * In later versions of the protocol it will always be with a length indicator.
     *
     * @param ctx
     * @param in
     */
    private Packet decodeGamePacket(Session<?> session, ChannelHandlerContext ctx, ByteBuf in) throws IOException {
        PacketIdentifier identifier = new DefaultPacketIdentifier(in.readUnsignedByte(), state());
        PacketDefinition definition = this.serverContext.getPacketRepository().getPacketDefinition(identifier);

        checkpoint(ConnectionState.AUTHENTICATION);

        return new ReadOnlyPacket(identifier, this.inputStreamProvider.provide(in.readBytes(this.getLength(definition, in))));
    }

    /**
     * Gets the length of the packet, depending on the metadata, this is either fixed value, byte or short
     *
     * @param definition
     * @param in
     * @return
     */
    private int getLength(PacketDefinition definition, ByteBuf in) {
        switch (checkNotNull(definition).getMetaData()) {
            case EMPTY:
                return definition.getExpectedLength();
            case SMALL:
                return in.readUnsignedByte();
            case BIG:
                return in.readUnsignedShort();
        }
        throw new UnsupportedOperationException("attempting to read unknown packet type");
    }

}

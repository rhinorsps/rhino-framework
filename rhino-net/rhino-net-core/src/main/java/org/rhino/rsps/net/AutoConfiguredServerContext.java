package org.rhino.rsps.net;

import org.rhino.rsps.net.packet.definition.PacketDefinitionRepository;
import org.rhino.rsps.net.packet.definition.config.PacketDefinitionLoader;
import org.rhino.rsps.net.session.SessionManager;

import java.net.InetSocketAddress;
import java.util.Set;

public class AutoConfiguredServerContext extends AbstractServerContext {

    /**
     *
     */
    private final Set<PacketDefinitionLoader> packetDefinitionLoaders;

    public  AutoConfiguredServerContext(PacketDefinitionLoader... loaders) {
        this (Set.of(loaders));
    }

    public AutoConfiguredServerContext(Set<PacketDefinitionLoader> packetDefinitionLoaders) {
        this.packetDefinitionLoaders = packetDefinitionLoaders;
    }

    /**
     *
     * @return
     */
    public AutoConfiguredServerContext start() {
        return this;
    }

    @Override
    public InetSocketAddress getHostAddress() {
        return null;
    }

    @Override
    public PacketDefinitionRepository getRepository() {
        return null;
    }

    @Override
    public SessionManager getSessionManager() {
        return null;
    }
}

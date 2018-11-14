package org.rhino.rsps.net;

import org.rhino.rsps.net.packet.definition.PacketDefinitionRepository;
import org.rhino.rsps.net.session.SessionManager;

import java.net.InetSocketAddress;

public class ConfigurableServerContext extends AbstractServerContext {

    private InetSocketAddress hostAddress;
    private PacketDefinitionRepository repository;
    private SessionManager sessionManager;

    public void setHostAddress(InetSocketAddress hostAddress) {
        this.hostAddress = hostAddress;
    }

    public void setRepository(PacketDefinitionRepository repository) {
        this.repository = repository;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public InetSocketAddress getHostAddress() {
        return this.hostAddress;
    }

    @Override
    public PacketDefinitionRepository getRepository() {
        return this.repository;
    }

    @Override
    public SessionManager getSessionManager() {
        return this.sessionManager;
    }
}

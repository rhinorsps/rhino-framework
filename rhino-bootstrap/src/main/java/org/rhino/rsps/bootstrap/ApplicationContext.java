package org.rhino.rsps.bootstrap;

import org.rhino.rsps.net.ServerContext;

public interface ApplicationContext {

    /**
     * Gets the parent context (if any)
     *
     * @return
     */
    ApplicationContext getParentContext();



}

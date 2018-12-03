package org.rhino.rsps.bootstrap;

import org.rhino.rsps.bootstrap.autoconfigure.ApplicationContextAware;
import org.rhino.rsps.net.Server;
import org.rhino.rsps.net.ServerContext;

public interface ApplicationConfiguration extends ServerContext, ApplicationContextAware {

}

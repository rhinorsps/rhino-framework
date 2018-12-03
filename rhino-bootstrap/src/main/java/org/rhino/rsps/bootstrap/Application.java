package org.rhino.rsps.bootstrap;

import org.rhino.rsps.bootstrap.bean.BeanManager;

public class Application {

    /**
     *
     */
    private final ApplicationContext applicationContext;

    /**
     *
     */
    private final BeanManager beanManager = null;

    public Application(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     *
     */
    public Application configure(ApplicationConfiguration configuration) throws Exception {


        return this;
    }

    public Application start() throws Exception {
        return this;
    }

}

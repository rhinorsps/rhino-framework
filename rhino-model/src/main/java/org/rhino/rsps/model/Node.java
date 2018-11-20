package org.rhino.rsps.model;

public interface Node {

    /**
     * The id of the entity
     * @return
     */
    int id();

    /**
     * Destroys the entity
     */
    void destroy() throws Exception;

}

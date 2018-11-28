package org.rhino.rsps.model.item.container;

public interface ContainerListener {

    /**
     * Called when a container has been updated
     *
     * @param event
     */
    void containerUpdated(ContainerEvent event);

}

package org.rhino.rsps.model.item.container;

public interface ContainerListener<ITEM extends ContainerItem> {

    /**
     * Called when a container has been updated
     *
     * @param event
     */
    void containerUpdated(ContainerEvent<ITEM> event);

}

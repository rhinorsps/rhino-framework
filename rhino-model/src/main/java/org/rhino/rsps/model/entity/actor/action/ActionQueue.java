package org.rhino.rsps.model.entity.actor.action;

public interface ActionQueue {

    /**
     *
     * @param action
     * @return
     */
    ActionQueue queue(Action action);

    /**
     *
     * @param action
     * @return
     */
    Action poll(Action action);

    /**
     * The priority of an action
     */
    enum Priority {
        LOWEST, LOW, NORMAL, HIGH, HIGHEST;
    }
}

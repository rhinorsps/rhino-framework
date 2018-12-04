package org.rhino.rsps.model.entity.actor.action;

public interface ActionQueue {

    /**
     *
     * @param action
     * @return
     */
    ActionQueue queue(Action action, Priority priority);

    /**
     *
     * @return
     */
    Action poll();

    /**
     *
     * @return
     */
    ActionQueue clear();

    default ActionQueue queue(Action action) {
        return this.queue(action, Priority.NORMAL);
    }

    /**
     * The priority of an action
     */
    enum Priority {
        LOWEST, LOW, NORMAL, HIGH, HIGHEST;
    }
}

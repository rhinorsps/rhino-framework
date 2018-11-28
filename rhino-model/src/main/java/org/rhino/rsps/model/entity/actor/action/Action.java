package org.rhino.rsps.model.entity.actor.action;

import com.google.common.base.Stopwatch;

public interface Action {

    /**
     * Indicates the action is currently being executed
     * @return
     */
    boolean active();

}

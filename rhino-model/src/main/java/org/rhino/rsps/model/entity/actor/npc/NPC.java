package org.rhino.rsps.model.entity.actor.npc;

import org.rhino.rsps.model.entity.actor.Actor;

/**
 *
 */
public interface NPC extends Actor {

    /**
     * Gets the npc's definition
     *
     * @return
     */
    NPCDefinition getDefinition();

}

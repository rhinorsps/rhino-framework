package org.rhino.rsps.model.realm;

import org.rhino.rsps.model.entity.Entity;
import org.rhino.rsps.model.entity.actor.npc.NPC;
import org.rhino.rsps.model.entity.actor.player.Player;

public interface Realm {

    /**
     * Attempts to allocate a new player
     *
     * @return
     */
    Player allocatePlayer();

    /**
     * Attempts to allocate a new npc
     *
     * @return
     */
    NPC allocateNpc();

    /**
     * Destroys an entity
     *
     * @param entity
     */
    void destroy(Entity entity);

}

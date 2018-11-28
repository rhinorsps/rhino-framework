package org.rhino.rsps.model.realm;

import org.rhino.rsps.model.entity.Entity;
import org.rhino.rsps.model.entity.actor.npc.NPC;
import org.rhino.rsps.model.entity.actor.player.Player;
import org.rhino.rsps.model.entity.locale.Location;
import org.rhino.rsps.model.entity.object.GameObject;

import java.util.Set;

public interface Region {

    int WIDTH = 8;
    int HEIGHT = 8;

    /**
     * The location of the region
     *
     * @return
     */
    Location getLocation();

    /**
     * The players in the region
     *
     * @return
     */
    Set<Player> getPlayers();

    /**
     * The npc's in the region
     *
     * @return
     */
    Set<NPC> getNpcs();

    /**
     * The objects in the region
     *
     * @return
     */
    Set<GameObject> getObjects();

}

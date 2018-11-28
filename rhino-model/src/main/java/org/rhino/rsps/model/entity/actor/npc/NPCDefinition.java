package org.rhino.rsps.model.entity.actor.npc;

public interface NPCDefinition {

    /**
     * The id of the npc in the client (e.g. 0 is the ID for Hans)
     *
     * @return
     */
    int getId();

    /**
     * The npc's name
     *
     * @return
     */
    String getName();

    /**
     * The npc's examine text
     *
     * @return
     */
    String getDescription();

    /**
     * Gets the size of the NPC, NPC's are always as width as they are tall, so for
     * example will be 1x1, 2x2, 3x3, ...
     *
     * @return
     */
    int getSize();

}

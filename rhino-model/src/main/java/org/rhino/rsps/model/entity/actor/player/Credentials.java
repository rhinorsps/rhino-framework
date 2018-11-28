package org.rhino.rsps.model.entity.actor.player;

public interface Credentials {

    /**
     *
     * @return
     */
    String getUuid();

    /**
     *
     * @return
     */
    String getUsername();

    /**
     *
     * @return
     */
    String getPassword();

    /**
     *
     * @return
     */
    String getDisplayName();

    /**
     *
     * @return
     */
    Privileges getPrivileges();

    /**
     * The privileges of the user
     */
    enum Privileges {
        NORMAL, ELEVATED, FULL;
    }

}

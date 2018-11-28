package org.rhino.rsps.model.entity.actor;

import org.rhino.rsps.model.entity.AbstractEntity;
import org.rhino.rsps.model.entity.actor.action.ActionQueue;
import org.rhino.rsps.model.entity.actor.transformation.Transformations;
import org.rhino.rsps.model.entity.locale.route.Route;
import org.rhino.rsps.model.realm.Realm;

public abstract class AbstractActor extends AbstractEntity implements Actor {

    /**
     * No need to insert location here yet, as the locations are usually loaded separately
     *
     * @param id
     */
    public AbstractActor(int id) {
        super(id);
    }

    @Override
    public Transformations getTransformations() {
        return null;
    }

}

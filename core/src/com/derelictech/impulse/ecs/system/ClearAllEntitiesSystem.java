package com.derelictech.impulse.ecs.system;

import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;
import com.derelictech.impulse.Impulse;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.ecs.system
 * Author:  voxelv
 * Creation Date: 2017-04-01
 * Description: Can clear all entities from a world when deleteAll is called.
 */
public class ClearAllEntitiesSystem extends IteratingSystem {

    static boolean do_it = false;
    static boolean prev_do_it = do_it;
    /**
     * Creates a new ClearAllEntitiesSystem.
     */
    @SuppressWarnings("unchecked")
    public ClearAllEntitiesSystem() {
        super(Aspect.all());
    }

    @Override
    protected void process(int entityId) {
        if(do_it && !prev_do_it) {
            Impulse.world().delete(entityId);
        }
    }

    @Override
    protected void end() {
        super.end();
        prev_do_it = do_it;
    }

    public static void deleteAll() {
        do_it = true;
    }

    public static void reset() {
        do_it = false;
        prev_do_it = false;
    }

}

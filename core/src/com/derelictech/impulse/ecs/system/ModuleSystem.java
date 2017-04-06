package com.derelictech.impulse.ecs.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IntervalIteratingSystem;
import com.badlogic.gdx.Gdx;
import com.derelictech.impulse.CONST;
import com.derelictech.impulse.Impulse;
import com.derelictech.impulse.ecs.component.ModuleComponent;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.ecs.system
 * Author:  voxelv
 * Creation Date: 2017-04-05
 * Description:
 */
public class ModuleSystem extends IntervalIteratingSystem {
    static ComponentMapper<ModuleComponent> mModuleComponent;

    /**
     * Creates a new IntervalEntityProcessingSystem.
     *
     */
    @SuppressWarnings("unchecked")
    public ModuleSystem() {
        super(Aspect.all(ModuleComponent.class), CONST.MODULE_PROCESS_INTERVAL);
    }

    @Override
    protected void process(int entityId) {
        switch(mModuleComponent.get(entityId).type) {
            case TYPE1:
                Gdx.app.debug("MODL_SYSM", "got TYPE1");
                break;
            case TYPE2:
                Gdx.app.debug("MODL_SYSM", "got TYPE2");
                break;
        }
    }

    public static void addModule(ModuleComponent.Type type) {
        int entityID = Impulse.world().create();
        mModuleComponent.create(entityID).type = type;
    }
}

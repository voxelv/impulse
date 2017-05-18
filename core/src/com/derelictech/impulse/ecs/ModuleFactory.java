package com.derelictech.impulse.ecs;

import com.artemis.World;
import com.derelictech.impulse.ecs.system.ModuleSystem;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.ecs
 * Author:  voxelv
 * Creation Date: 2017-05-17
 * Description:
 */
public class ModuleFactory {
    public void buildInputBuffer(World world) {
        ModuleSystem ms = world.getSystem(ModuleSystem.class);
        // TODO stuff n things
    }
}

package com.derelictech.impulse.game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.game
 * File:    ModuleRecipe.java
 * Author:  voxelv
 * Creation Date: 2017-03-07
 * Description: Describes a recipe to make a {@link Module}
 */
public class ModuleRecipe<T extends ImpulsePacket> extends ArrayList<T> {
    public static final ModuleRecipe module1 = (ModuleRecipe) Arrays.asList(
            new PHI(64),
            new PHI(128),
            new PHI(128),
            new XI(1));
}



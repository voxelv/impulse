package com.derelictech.impulse.game;

import com.derelictech.impulse.Impulse;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.game
 * Author:  voxelv
 * Creation Date: 2017-03-07
 * Description: Interface for objects that have an impulse type
 */
public interface HasImpulseType {
    /**
     * What type of impulse the object has
     * @return the type of impulse
     */
    Impulse.Type getType();
}

package com.derelictech.impulse.game;

import com.derelictech.impulse.Impulse;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.game
 * Author:  voxelv
 * Creation Date: 2017-03-07
 * Description: An {@link ImpulsePacket} of XI, Ξ
 */
public class XI extends ImpulsePacket {

    /**
     * XI ImpulsePacket Constructor
     */
    public XI(long xi_value) {
        super(Impulse.Type.XI_Ξ);
        value = xi_value;
    }
}

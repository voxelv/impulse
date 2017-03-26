package com.derelictech.impulse.game;

import com.derelictech.impulse.Impulse;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.game
 * Author:  voxelv
 * Creation Date: 2017-03-07
 * Description: An {@link ImpulsePacket} of PHI, Φ
 */
public class PHI extends ImpulsePacket {

    /**
     * PHI ImpulsePacket Constructor
     */
    public PHI(long phi_value) {
        super(Impulse.Type.PHI_Φ);
        value = phi_value;
    }
}

package com.derelictech.impulse.game;

import com.derelictech.impulse.Impulse;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.game
 * Author:  voxelv
 * Creation Date: 2017-03-07
 * Description: A connection between two {@link ImpulseConnector}s
 */
public class ImpulseConnection implements HasImpulseType{
    private Impulse.Type type;
    private ImpulseConnector input, output;

    public ImpulseConnection(Impulse.Type impulse_type) {
        type = impulse_type;
    }

    @Override
    public Impulse.Type getType() {
        return type;
    }
}

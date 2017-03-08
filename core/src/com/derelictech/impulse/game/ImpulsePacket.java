package com.derelictech.impulse.game;

import com.derelictech.impulse.Impulse;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.game
 * Author:  voxelv
 * Creation Date: 2017-03-07
 * Description: A bit of impulse (either Ξ or Φ)
 */
public abstract class ImpulsePacket implements HasImpulseType {
    private Impulse.Type type;
    long value;

    /**
     * ImpulsePacket Constructor
     * @param packet_type The type of {@link Impulse.Type} for this packet.
     */
    public ImpulsePacket(Impulse.Type packet_type) {
        type = packet_type;
    }

    @Override
    public Impulse.Type getType() {
        return type;
    }

    public void setType(Impulse.Type type) {
        this.type = type;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}

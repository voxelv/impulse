package com.derelictech.impulse.game;

import com.derelictech.impulse.Impulse;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * Author:  voxelv
 * Creation Date: 2017-03-07
 * Description: Manages input/output to/from a {@link Module}
 */
public class ImpulseConnector {
//
//    private Impulse.Type type;
//    private ImpulsePacket buffer;
//    private Module parent;
//
//    public ImpulseConnector(Impulse.Type impulse_type, Module connector_parent) {
//        type = impulse_type;
//        parent = connector_parent;
//    }
//
//    public Module getParent() {
//        return parent;
//    }
//
//    /**
//     * Send out an {@link ImpulsePacket} from the parent {@link Module}
//     * @param ip The {@link ImpulsePacket} to send
//     * @return Whether the buffer was empty, if not, the {@link Module} should block
//     */
//    public boolean tx(ImpulsePacket ip) {
//        if(buffer == null) {
//            buffer = ip;
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    /**
//     * Bring in an {@link ImpulsePacket} to the parent {@link Module}
//     * @return The buffer's impulse packet.
//     *   null if no packet is in the buffer, in which case, the parent {@link Module} should block
//     */
//    public ImpulsePacket rx() {
//        return buffer;
//    }
//
//    @Override
//    public Impulse.Type getType() {
//        return type;
//    }
}

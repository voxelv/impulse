package com.derelictech.impulse.ecs.component;

import com.artemis.Component;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.ecs.component
 * Author:  voxelv
 * Creation Date: 2017-04-05
 * Description:
 */
public class ModuleComponent extends Component {
    public enum Type {
        INPUT_BUFFER,
        SCORE_BUFFER,
        TYPE1,
        TYPE2
    }
    public Type type;
    public boolean online = false;
}

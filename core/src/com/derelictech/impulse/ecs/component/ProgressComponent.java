package com.derelictech.impulse.ecs.component;

import com.artemis.Component;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.ecs.component
 * Author:  voxelv
 * Creation Date: 2017-05-17
 * Description: A progress component has a value between 0.0 and 1.0. When it reaches 1.0, the process is complete
 *      and the progress is set back to 0.0 *
 */
public class ProgressComponent extends Component {
    // Percent Complete
    public float percent = 0.0f;

    // Percent Per Second
    public float pps;
}

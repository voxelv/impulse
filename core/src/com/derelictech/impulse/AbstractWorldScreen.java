package com.derelictech.impulse;

import com.artemis.World;
import com.badlogic.gdx.ScreenAdapter;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * Author:  voxelv
 * Creation Date: 2017-03-30
 * Description:
 */
public abstract class AbstractWorldScreen extends ScreenAdapter {
    protected World world;

    protected abstract World createWorld();

    @Override
    public void show() {
        if(world == null) {
            world = createWorld();
        }
    }

    @Override
    public void render(float delta) {
        world.setDelta(delta);
        world.process();
    }

    @Override
    public void hide() {
        world.dispose();
        world = null;
    }
}

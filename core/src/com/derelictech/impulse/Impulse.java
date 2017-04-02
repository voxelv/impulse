package com.derelictech.impulse;

import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.derelictech.impulse.ecs.system.ClearAllEntitiesSystem;
import com.derelictech.impulse.ecs.system.ConsolePrintSystem;
import com.derelictech.impulse.ecs.system.ScreenManager;
import com.kotcrab.vis.ui.VisUI;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    Impulse.java
 * Author:  voxelv
 * Creation Date: 2017-03-05
 * Description: Impulse Game
 */

public class Impulse extends Game {
    private static World w;
    private static Game g;
    public static boolean do_debug = false;

    public Impulse() {
        super();
        g = this;
    }

    @Override
	public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        VisUI.load(VisUI.SkinScale.X1);

        if(w == null) {

            w = new World(new WorldConfigurationBuilder()
                    .with(new ScreenManager())

                    .with(new ConsolePrintSystem())

                    .with(new ClearAllEntitiesSystem())

                    .build());
        }
	}

    @Override
    public void render() {
        w.setDelta(Gdx.graphics.getDeltaTime());
        w.process();

        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        VisUI.dispose();
        w.dispose();
    }

    public static Game game() {
        if(g != null)
            return g;
        else
            throw new NullPointerException("Impulse.game was null!");
    }

    public static World world() {
        if(w != null)
            return w;
        else
            throw new NullPointerException("Impulse.world was null!");
    }
}

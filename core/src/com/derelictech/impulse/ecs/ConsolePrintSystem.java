package com.derelictech.impulse.ecs;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IntervalIteratingSystem;
import com.badlogic.gdx.Gdx;
import com.derelictech.impulse.MainGameScreen;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.ecs
 * Author:  voxelv
 * Creation Date: 2017-03-29
 * Description:
 */
public class ConsolePrintSystem extends IntervalIteratingSystem {
    static ComponentMapper<PrintableText> mPrintableText;
    /**
     * Creates a new ConsolePrintSystem.
     */
    public ConsolePrintSystem() {
        super(Aspect.all(PrintableText.class), 1.0f);
    }

    public static void create(String text) {
        mPrintableText.create(MainGameScreen.world.create()).text = text;
    }

    @Override
    protected void process(int entityId) {
        String txt = mPrintableText.get(entityId).text;
        Gdx.app.debug("TAG", "MESSAGE FROM: " + entityId + " SAYING: " + txt);
    }
}

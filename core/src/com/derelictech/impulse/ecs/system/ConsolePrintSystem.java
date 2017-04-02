package com.derelictech.impulse.ecs.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Wire;
import com.artemis.systems.IntervalIteratingSystem;
import com.badlogic.gdx.Gdx;
import com.derelictech.impulse.Impulse;
import com.derelictech.impulse.ecs.component.PrintableText;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.ecs
 * Author:  voxelv
 * Creation Date: 2017-03-29
 * Description:
 */
@Wire
public class ConsolePrintSystem extends IntervalIteratingSystem {
    ComponentMapper<PrintableText> mPrintableText;
    /**
     * Creates a new ConsolePrintSystem.
     */
    @SuppressWarnings("unchecked")
    public ConsolePrintSystem() {
        super(Aspect.all(PrintableText.class), 1.0f);
    }

    public void create(String text) {
        mPrintableText.create(Impulse.world().create()).text = text;
    }

    @Override
    protected void process(int entityId) {
        String text = mPrintableText.get(entityId).text;

        if(text.equals("OHAI") && mPrintableText.get(entityId).enabled) {
            mPrintableText.get(entityId).enabled = false;
            Gdx.app.debug("PRNT_SYS", "msg: " + text + " en: " + mPrintableText.get(entityId).enabled);
        }

        if(mPrintableText.get(entityId).enabled) {
            Gdx.app.debug("TAG", "MESSAGE FROM: " + entityId + " SAYING: " + text);
        }
    }
}

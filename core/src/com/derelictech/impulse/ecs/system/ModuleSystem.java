package com.derelictech.impulse.ecs.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IntervalIteratingSystem;
import com.badlogic.gdx.Gdx;
import com.derelictech.impulse.CONST;
import com.derelictech.impulse.Impulse;
import com.derelictech.impulse.ecs.component.ImpulseBuffersComponent;
import com.derelictech.impulse.ecs.component.ModuleComponent;
import com.derelictech.impulse.ecs.component.ModuleComponent.Type;
import com.derelictech.impulse.ecs.component.ProgressComponent;
import com.derelictech.impulse.util.InfoLog;

import java.util.HashMap;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.ecs.system
 * Author:  voxelv
 * Creation Date: 2017-04-05
 * Description:
 */
public class ModuleSystem extends IntervalIteratingSystem {
    static ComponentMapper<ModuleComponent> mModuleComponent;
    static ComponentMapper<ProgressComponent> mProgressComponent;
    static ComponentMapper<ImpulseBuffersComponent> mImpulseBuffersComponent;

    // The singular input buffer for this system
    private int inputBuffer;
    private int scoreBuffer;

    /**
     * Creates a new IntervalEntityProcessingSystem.
     *
     */
    @SuppressWarnings("unchecked")
    public ModuleSystem() {
        super(Aspect.all(ModuleComponent.class, ImpulseBuffersComponent.class), CONST.MODULE_PROCESS_INTERVAL);
    }

    @Override
    protected void initialize() {
        inputBuffer = world.create();
        mModuleComponent.create(inputBuffer).type = Type.INPUT_BUFFER;
        mModuleComponent.create(inputBuffer).online = true;
        mProgressComponent.create(inputBuffer).pps = CONST.INPUT_BUFFER_SECONDS_PER_IMPULSE;
        mImpulseBuffersComponent.create(inputBuffer).buffers = new HashMap<String, Long>();

        scoreBuffer = world.create();
        mModuleComponent.create(scoreBuffer).type = Type.SCORE_BUFFER;
        mModuleComponent.create(scoreBuffer).online = true;
        mImpulseBuffersComponent.create(scoreBuffer).buffers = new HashMap<String, Long>();
    }

    @Override
    protected void process(int entityId) {
        ModuleComponent moduleComp = mModuleComponent.get(entityId);
        ProgressComponent progressComp = mProgressComponent.get(entityId);
        ImpulseBuffersComponent bufComp = mImpulseBuffersComponent.get(entityId);


        switch(moduleComp.type) {
            case INPUT_BUFFER:
                if(processProgress(entityId, moduleComp, progressComp)) {
                    bufComp.buffers.put("internal", 1L);
                    InfoLog.push("MODL_SYSM", "INPUT has: " + 1L);
                }
                break;
            case SCORE_BUFFER:
                InfoLog.push("MODL_SYSM", "Processed SCORE_BUFFER");
                break;
            case TYPE1:
                InfoLog.push("MODL_SYSM", "got TYPE1");
                break;
            case TYPE2:
                InfoLog.push("MODL_SYSM", "got TYPE2");
                break;
            default:
                break;
        }
    }

    private boolean processProgress(int entityId, ModuleComponent mc, ProgressComponent pc) {
        // Process the ProgressComponent
        float delta = Gdx.graphics.getDeltaTime();
        boolean progress_done = false;

        if(mc.online) {
            mProgressComponent.get(entityId).percent = pc.percent + (pc.pps * delta);
        }

        if(pc.percent >= 1.0) {
            progress_done = true;
            mProgressComponent.get(entityId).percent = pc.percent - 1.0f;
        }

        return progress_done;
    }

    /**
     * Creates a Module!
     * @param type The kind of module to make
     * @param pps How much progress 'percent per second'
     */
    public static void addModule(Type type, float pps) {
        // Skip INPUT_BUFFER and SCORE_BUFFER types
        if(type == ModuleComponent.Type.INPUT_BUFFER || type == Type.SCORE_BUFFER) {
            return;
        }

        int entityID = Impulse.world().create();
        mModuleComponent.create(entityID).type = type;
        mProgressComponent.create(entityID).pps = pps;
        mImpulseBuffersComponent.create(entityID).buffers = new HashMap<String, Long>();
    }
}

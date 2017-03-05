package com.derelictech.impulse;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kotcrab.vis.runtime.font.FontProvider;
import com.kotcrab.vis.runtime.font.FreeTypeFontProvider;
import com.kotcrab.vis.runtime.scene.VisAssetManager;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    ImpulseAssetManager.java
 * Author:  voxelv
 * Creation Date: 2017-03-04
 * Description: Wraps VisAssetManager for convenience
 */
public class ImpulseAssetManager extends VisAssetManager {

    public static Batch batch;
    public static FreeTypeFontProvider freetypefontprovider;

    public ImpulseAssetManager() {
        super(batch = new SpriteBatch());
    }

    public void enableFreeType() {
        super.enableFreeType(freetypefontprovider = new FreeTypeFontProvider());
    }
}

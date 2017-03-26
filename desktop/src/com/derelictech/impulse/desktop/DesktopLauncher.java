package com.derelictech.impulse.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.derelictech.impulse.Impulse;

public class DesktopLauncher {
    private static boolean REPACK_TEXTURES = true;

	public static void main (String[] arg) {
	    if(REPACK_TEXTURES) {
//            TexturePacker.process(Gdx.files.getLocalStoragePath(), "packs", "pack");
        }
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 640;
		config.height = 480;
		new LwjglApplication(new Impulse(), config);
	}
}

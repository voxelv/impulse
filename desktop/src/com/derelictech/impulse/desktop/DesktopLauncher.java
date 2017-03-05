package com.derelictech.impulse.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.derelictech.impulse.Impulse;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.resizable = false;
        config.initialBackgroundColor = new Color(0x303030FF);
        config.title = "Impulse";
        config.addIcon("impulse_icon_wip_16.png", Files.FileType.Internal);
        config.addIcon("impulse_icon_wip_32.png", Files.FileType.Internal);
        config.addIcon("impulse_icon_wip_128.png", Files.FileType.Internal);
		new LwjglApplication(new Impulse(), config);
	}
}

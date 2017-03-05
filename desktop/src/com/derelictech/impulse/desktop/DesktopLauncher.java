package com.derelictech.impulse.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.derelictech.impulse.CONST;
import com.derelictech.impulse.Impulse;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = CONST.INIT_SCREEN_W;
        config.height = CONST.INIT_SCREEN_H;
        config.initialBackgroundColor = new Color(0x202020FF);
        config.title = "Impulse";
        config.addIcon("gfx/impulse_icon_wip_16.png", Files.FileType.Internal);
        config.addIcon("gfx/impulse_icon_wip_32.png", Files.FileType.Internal);
        config.addIcon("gfx/impulse_icon_wip_128.png", Files.FileType.Internal);
		new LwjglApplication(new Impulse(), config);
	}
}

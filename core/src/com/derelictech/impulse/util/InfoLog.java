package com.derelictech.impulse.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.derelictech.impulse.Impulse;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisScrollPane;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisWindow;

import java.util.ArrayList;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.util
 * Author:  voxelv
 * Creation Date: 2017-05-19
 * Description: Holds lines and manages the lines that are held
 */
public class InfoLog extends VisTable {
    private static AutoScrollingTextTable logTable = new AutoScrollingTextTable();

    public static void push(String line) {
        Gdx.app.debug("INFO_LOGG", line);
        logTable.push(line);
    }

    public static void push(String tag, String line) {
        Gdx.app.debug(tag, line);
        if(Impulse.do_debug) {
            logTable.push(tag, line);
        }
    }

    public static VisTable getTable() {
        return logTable;
    }
}

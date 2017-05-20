package com.derelictech.impulse.util;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.util
 * Author:  voxelv
 * Creation Date: 2017-05-19
 * Description: Holds lines and manages the lines that are held
 */
public class CommandLog {
    public static final int MAX_LINES = 20;
    private ArrayList<String> lines = new ArrayList<String>(50);
    private static CommandLog inst = new CommandLog();

    public static void push(String line) {
        if(inst.lines.size() < MAX_LINES) {
            inst.lines.add(line);
        }
        else {
            inst.lines.remove(0);
            inst.lines.add(line);
        }
    }

    public static void push(String tag, String line) {
        Gdx.app.debug(tag, line);
        push("[" + tag + "]" + " " + line);
    }

    public static ArrayList<String> getLines() {
        return inst.lines;
    }
}

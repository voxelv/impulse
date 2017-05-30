package com.derelictech.impulse.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
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
        logTable.push(tag, line);
    }

    public static VisTable getTable() {
        return logTable;
    }

//    private static InfoLog inst = new InfoLog();
//
//    static boolean dirty = false;
//    public static final int MAX_LINES = 500;
//    private static ArrayList<VisLabel> lines = new ArrayList<VisLabel>(MAX_LINES);
//
//    private static VisTable table = new VisTable();
//    private static VisScrollPane scrollPane = new VisScrollPane(table);
//
//    static {
//        inst.add(scrollPane).bottom().left().expand();
//    }
//
//    public static void push(String line) {
//        if(lines.size() < MAX_LINES) {
//            lines.add(new VisLabel(line));
//        }
//        else {
//            VisLabel tmp = lines.remove(0);
//            tmp.setText(line);
//            lines.add(tmp);
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append("\n\t");
//        for(VisLabel v : lines) {
//            sb.append(v.getText());
//            sb.append("\n\t");
//        }
//        Gdx.app.debug("INFO_LOGG", sb.toString());
//        dirty = true;
//    }
//
//    public static void push(String tag, String line) {
//        Gdx.app.debug(tag, line);
//        push("[" + tag + "]" + " " + line);
//    }
//
//    @Override
//    public void act(float delta) {
//        super.act(delta);
//        if(dirty) {
//            table.clearChildren();
//            for(VisLabel v : lines) {
//                table.add(v).left().row();
//            }
//            scrollPane.scrollTo(0, 0, 0, 0);
//            dirty = false;
//        }
//    }
//
//    public static InfoLog getTable() {
//        return inst;
//    }
}

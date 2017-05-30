package com.derelictech.impulse.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisScrollPane;
import com.kotcrab.vis.ui.widget.VisTable;

import java.util.ArrayList;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.util
 * Author:  voxelv
 * Creation Date: 2017-05-30
 * Description:
 */
public class AutoScrollingTextTable extends VisTable {
    public static final int MAX_LINES = 20;

    boolean dirty = false;
    boolean mouseOver = false;

    private ArrayList<VisLabel> lines = new ArrayList<VisLabel>();

    private VisTable table = new VisTable();
    private VisScrollPane scrollPane = new VisScrollPane(table);

    public AutoScrollingTextTable() {
        add(scrollPane).bottom().left().expand();
        scrollPane.setSmoothScrolling(false);

        addListener(new ClickListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                super.enter(event, x, y, pointer, fromActor);
                mouseOver = true;
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                super.exit(event, x, y, pointer, toActor);
                mouseOver = false;
            }
        });
    }

    public void push(String line) {
        if(lines.size() < MAX_LINES) {
            lines.add(new VisLabel(line));
        }
        else {
            VisLabel tmp = lines.remove(0);
            tmp.setText(line);
            lines.add(tmp);
        }
        dirty = true;
    }

    public void push(String tag, String line) {
        push("[" + tag + "]" + " " + line);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(dirty) {
            scrollPane.updateVisualScroll();
            table.clearChildren();
            for(VisLabel v : lines) {
                table.add(v).left().row();
            }
            if(!mouseOver) {
                scrollPane.scrollTo(0, 0, 0, 0);
            }
            scrollPane.updateVisualScroll();
            dirty = false;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}

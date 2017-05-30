package com.derelictech.impulse;

import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.derelictech.impulse.ecs.component.ModuleComponent;
import com.derelictech.impulse.ecs.system.ClearAllEntitiesSystem;
import com.derelictech.impulse.ecs.system.ConsolePrintSystem;
import com.derelictech.impulse.ecs.system.ModuleSystem;
import com.derelictech.impulse.ecs.system.ScreenManager;
import com.derelictech.impulse.game.Module;
import com.derelictech.impulse.game.ModuleRecipe;
import com.derelictech.impulse.game.ModuleRecipes;
import com.derelictech.impulse.util.InfoLog;
import com.kotcrab.vis.ui.FocusManager;
import com.kotcrab.vis.ui.util.Validators;
import com.kotcrab.vis.ui.widget.*;

import java.util.ArrayList;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    MainGameScreen.java
 * Author:  voxelv
 * Creation Date: 2017-03-05
 * Description: Main Game Screen
 */
public class MainGameScreen extends ImpulseScreenAdapter {

    private VisTextButton back_btn;
    private VisValidatableTextField input_text;
    private VisLabel output_text;

    private ScrollableTextArea infoTextArea;

    private int LIST_ELEMENT_HEIGHT = 30;
    private int LIST_ELEMENT_PAD = 0;
    private int LIST_ELEMENT_WIDTH = 400;

    public MainGameScreen(Game g) {
        super(g);
    }

    @Override
    public void show() {
        super.show();

        ModuleRecipes.load();

        ConsolePrintSystem cps = Impulse.world().getSystem(ConsolePrintSystem.class);
        ClearAllEntitiesSystem.reset();

        cps.create("TEST");
        cps.create("OHAI");
        cps.create("WRLD");

        back_btn = new VisTextButton("BACK");
        input_text = new VisValidatableTextField(Validators.INTEGERS);
        output_text = new VisLabel("");

        VisTable mainAreaMenu = new VisTable();

            VisTable dbg_menu = new VisTable();

                dbg_menu.add(new VisLabel("HELLO GAME SCENE")).pad(LIST_ELEMENT_PAD).height(LIST_ELEMENT_HEIGHT);

                dbg_menu.row();
                dbg_menu.add(output_text).left().pad(LIST_ELEMENT_PAD).height(LIST_ELEMENT_HEIGHT);
                dbg_menu.row();
                dbg_menu.add(input_text).width(LIST_ELEMENT_WIDTH).pad(LIST_ELEMENT_PAD).height(LIST_ELEMENT_HEIGHT);
                dbg_menu.row();

                VisTextButton module_btn= new VisTextButton("NEW MODULE");
                dbg_menu.add(module_btn).fillX().pad(LIST_ELEMENT_PAD).height(LIST_ELEMENT_HEIGHT);

                dbg_menu.row();
                VisTextButton module1_btn = new VisTextButton("MODULE TYPE1");
                dbg_menu.add(module1_btn).fillX().pad(LIST_ELEMENT_PAD).height(LIST_ELEMENT_HEIGHT);
                dbg_menu.row();
                VisTextButton module2_btn = new VisTextButton("MODULE TYPE2");
                dbg_menu.add(module2_btn).fillX().pad(LIST_ELEMENT_PAD).height(LIST_ELEMENT_HEIGHT);
                dbg_menu.row();

            mainAreaMenu.add(dbg_menu).top();

            mainAreaMenu.add(makeModuleList()).top();

            mainAreaMenu.add(makeInfoTable()).top();


        root.add(mainAreaMenu).top();
        root.row();

        root.add(new Table()).expand();
        root.row();

        root.add(InfoLog.getTable()).height(300).bottom().left().expand().row();

        root.add(back_btn).fillX().pad(LIST_ELEMENT_PAD).height(LIST_ELEMENT_HEIGHT).bottom().left().width(LIST_ELEMENT_WIDTH);

        ////////////////////// Event Handling //////////////////////
        back_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ScreenManager.setScreen("menu");
            }
        });

        input_text.addListener(new InputListener() {
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                switch (keycode) {
                    case Input.Keys.ENTER:
                        String text = ((VisValidatableTextField) (event.getTarget())).getText();
                        boolean textbox_valid = ((VisValidatableTextField) event.getTarget()).isInputValid();

                        if(textbox_valid) {
                            output_text.setText("I can haz " + Integer.parseInt(text) + CONST.XI + "?");
                            input_text.setText("");
                        }
                    case Input.Keys.ESCAPE:
                        FocusManager.resetFocus(stage);
                        break;
                    default:
                        break;
                }
                return true;
            }
        }); /* END input_text.addListener() */

        module_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Module module = new Module();
            }
        });

        module1_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ModuleSystem.addModule(ModuleComponent.Type.TYPE1, 1.0f);
            }
        });

        module2_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ModuleSystem.addModule(ModuleComponent.Type.TYPE2, 2.0f);
            }
        });
    }

    private VisTable makeInfoTable() {
        VisTable infoTable = new VisTable();
        infoTable.top();

        infoTextArea = new ScrollableTextArea("")
//        TODO: Clear text after some seconds, implement later
//        {
//            Timer.Task clearTimer = new Timer.Task(){
//                @Override
//                public void run() {
//                    setText("");
//                }
//            };
//            public void setText(String str) {
//                super.setText(str);
//
//                if(clearTimer != null && !str.equals("")) {
//                    if (clearTimer.isScheduled()) {
//                        clearTimer.cancel();
//                    } else {
//                        Timer.schedule(clearTimer, 3);
//                    }
//                }
//            }
//        }
        ;

        infoTable.add(infoTextArea).size(400, 150);

        return infoTable;
    }

    private VisTable makeModuleList() {
        VisTable moduleListTable = new VisTable();
        moduleListTable.setDebug(Impulse.do_debug, true);
        moduleListTable.top();

        ArrayList<ModuleRecipe> moduleRecipes = ModuleRecipes.getRecipes();
        for(final ModuleRecipe recipe : moduleRecipes) {
            VisTextButton btn = new VisTextButton(recipe.name);
            moduleListTable.add(btn).pad(LIST_ELEMENT_PAD).height(LIST_ELEMENT_HEIGHT);
            moduleListTable.row();

            //////////////////////
            btn.addListener(new ClickListener(Input.Buttons.LEFT){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    String str = "New Module Button: " + recipe.name + " was clicked!\n" + "  Recipe:" +
                            "\n    " + CONST.XI + ": " + recipe.xi.toString() +
                            "\n    " + CONST.PHI + ": " + recipe.phi.toString();
                    InfoLog.push("GAME_SCRN", str);

                    infoTextArea.setText(str);
                }
            });
        }
        return moduleListTable;
    }

    @Override
    public void hide() {
        super.hide();
        ClearAllEntitiesSystem.deleteAll();
    }

    @Override
    public void render(float delta) {
        // TODO: Get list of stuff from the world to render, and put it on stage or root to render

        super.render(delta);
    }
}

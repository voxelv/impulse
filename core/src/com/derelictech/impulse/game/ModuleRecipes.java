package com.derelictech.impulse.game;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonWriter;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Project: impulse
 * Package: com.derelictech.impulse.game
 * File:    ModuleRecipes.java
 * Author:  voxelv
 * Creation Date: 2017-03-07
 * Description: Describes a recipe to make a {@link Module}
 */
public class ModuleRecipes {

    private static ModuleRecipes inst;

    private static HashMap<String, ModuleRecipe> recipes;

    public static void load(){
        import_recipes();
    }

    private static void import_recipes() {
        inst = new ModuleRecipes();
        FileHandle cnfg_file = Gdx.files.getFileHandle("cnfg_module_recipes.json", Files.FileType.Internal);

        Json json = new Json(JsonWriter.OutputType.json);
        json.setElementType(ModuleRecipes.class, "recipes", ModuleRecipe.class);

        JSONTest newjt = json.fromJson(
                JSONTest.class,
                cnfg_file);

        Gdx.app.debug("MR", newjt.toString());
    }

    static ModuleRecipe getRecipe(String module_name) {
//        return recipes.get(module_name);
        Gdx.app.debug("MR", "Hello test from getRecipe" + recipes.toString());
        return null;
    }

    public static HashMap<String, ModuleRecipe> getRecipes() {
        return recipes;
    }

    public static void setRecipes(HashMap<String, ModuleRecipe> recipes) {
        inst.recipes = recipes;
    }
}


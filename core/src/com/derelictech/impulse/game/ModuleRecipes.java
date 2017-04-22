package com.derelictech.impulse.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

import java.util.ArrayList;


/**
 * Project: impulse
 * Package: com.derelictech.impulse.g
 * File:    ModuleRecipes.java
 * Author:  voxelv
 * Creation Date: 2017-03-07
 * Description: Describes a recipe to make a {@link Module}
 */
public class ModuleRecipes {
    private static final String tag = "MODL_RCPS";

    static final class ModuleRecipesHolder {
        private ArrayList<ModuleRecipe> recipes;

        ArrayList<ModuleRecipe> getRecipes() {
            return recipes;
        }
    }
    private static ModuleRecipesHolder holder;

    public static void load() {
        import_recipes();
    }

    private static void import_recipes() {
        FileHandle cnfg_file = Gdx.files.internal("cnfg_module_recipes.json");
        Gdx.app.debug(tag, "json path exists: " + cnfg_file.exists());

        Json json = new Json(JsonWriter.OutputType.json);

        json.setElementType(ModuleRecipesHolder.class, "recipes", ModuleRecipe.class);

        holder = json.fromJson(ModuleRecipesHolder.class, cnfg_file);

        Gdx.app.debug(tag, holder.toString());
    }

    public static ModuleRecipe getRecipe(String module_name) {
        Gdx.app.debug(tag, "Hello test from getRecipe" + holder.toString());
        return null;
    }

    public static ArrayList<ModuleRecipe> getRecipes() {
        return holder.getRecipes();
    }
}

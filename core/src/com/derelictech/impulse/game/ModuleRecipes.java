package com.derelictech.impulse.game;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Project: impulse
 * Package: com.derelictech.impulse.g
 * File:    ModuleRecipes.java
 * Author:  voxelv
 * Creation Date: 2017-03-07
 * Description: Describes a recipe to make a {@link Module}
 */
public class ModuleRecipes {

    static final class ModuleRecipesHolder {
        private JSONArray recipes;

        public ArrayList<ModuleRecipe> getRecipes() {
            return ((ArrayList<ModuleRecipe>) recipes);
        }
    }
    private static ModuleRecipesHolder holder;

    public static void load() {
        import_recipes();
    }

    private static void import_recipes() {
        FileHandle cnfg_file = Gdx.files.internal("cnfg_module_recipes.json");
        Gdx.app.debug("MODL_RCPS", "json path exists: " + cnfg_file.exists());

        Json json = new Json(JsonWriter.OutputType.json);

        json.setElementType(ModuleRecipesHolder.class, "recipes", ModuleRecipe.class);

        holder = json.fromJson(ModuleRecipesHolder.class, cnfg_file);

        Gdx.app.debug("MR", holder.toString());
    }

    public static ModuleRecipe getRecipe(String module_name) {
        Gdx.app.debug("MR", "Hello test from getRecipe" + holder.toString());
        return null;
    }

    public static ArrayList<ModuleRecipe> getRecipes() {
        return holder.getRecipes();
    }
}

package com.derelictech.impulse.game;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

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

    private static ModuleRecipesHolder holder;

    public static void load() {
        import_recipes();
    }

    private static void import_recipes() {
        FileHandle cnfg_file = Gdx.files.getFileHandle("cnfg_module_recipes.json", Files.FileType.Internal);

        Json json = new Json(JsonWriter.OutputType.json);

        json.setElementType(ModuleRecipesHolder.class, "recipes", ModuleRecipe.class);

        holder = json.fromJson(ModuleRecipesHolder.class, cnfg_file);

        Gdx.app.debug("MR", holder.toString());
    }

    public static ModuleRecipe getRecipe(String module_name) {
        Gdx.app.debug("MR", "Hello test from getRecipe" + holder.toString());
        return null;
    }
}

class ModuleRecipesHolder {
    private HashMap<String, ModuleRecipe> recipes;
}

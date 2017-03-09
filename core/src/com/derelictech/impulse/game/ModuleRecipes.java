package com.derelictech.impulse.game;
import com.badlogic.gdx.Gdx;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
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
public class ModuleRecipes extends ArrayList<ModuleRecipe> {
    public static final HashMap<String, ModuleRecipe> recipes;

    static {
        recipes = new HashMap<String, ModuleRecipe>();
        import_recipes();
    }

    private static void import_recipes(){
        JSONParser jsonParser = new JSONParser();
        JSONObject mojo = null;
        try {
            mojo = (JSONObject) jsonParser.parse(Gdx.files.internal("cnfg_module_recipes.json").reader());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Gdx.app.debug("MODULE RECIPE", mojo.toString());
    }
}



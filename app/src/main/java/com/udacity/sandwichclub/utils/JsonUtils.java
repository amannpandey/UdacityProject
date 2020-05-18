package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try{
            // Create main JSON object
            JSONObject jsonData = new JSONObject(json);
            // Get Names
            JSONObject names = jsonData.getJSONObject("name");
            // Get "mainName"
            String mainName = names.getString("mainName");
            // Get "alsoKnownAs" names
            JSONArray alsoKnownAsJsonArray = names.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs = new ArrayList<>();
            for(int i = 0; i < alsoKnownAsJsonArray.length(); i++){
                alsoKnownAs.add(alsoKnownAsJsonArray.getString(i));
            }
            // Get "placeOfOrigin"
            String placeOfOrigin = jsonData.getString("placeOfOrigin");
            // Get "description"
            String description = jsonData.getString("description");
            // Get "image"
            String imageUrl = jsonData.getString("image");
            // Get "ingredients"
            JSONArray ingredientsJsonArray = jsonData.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();
            for(int i = 0; i < ingredientsJsonArray.length(); i++){
                ingredients.add(ingredientsJsonArray.getString(i));
            }
            // Return Sandwich data
            return new Sandwich(
                    mainName,
                    alsoKnownAs,
                    placeOfOrigin,
                    description,
                    imageUrl,
                    ingredients
            );

        }catch(JSONException e){
            e.printStackTrace();
        }



        return null;
    }
}

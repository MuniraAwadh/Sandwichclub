package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static final String JSON_INTENT_KEY = "name";

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwichDetails=null;
       // if (sandwichDetails !=null){
            try {

                JSONObject sandwichObject = new JSONObject(json);
                JSONObject name = sandwichObject.getJSONObject(JSON_INTENT_KEY);
                String mainName = name.optString("mainName");
                List<String> alsoKnownAsList = new ArrayList<String>();
                JSONArray alsoKnownAs = name.optJSONArray("alsoKnownAs");
                for (int f = 0; f < alsoKnownAs.length(); f++) {
                   alsoKnownAsList.add(alsoKnownAs.optString(f));
                }
                String placeOfOrigin = sandwichObject.optString("placeOfOrigin");
                String description = sandwichObject.optString("description");
                String image = sandwichObject.optString("image");
                List<String> ingredientsList = new ArrayList<String>();
                JSONArray ingredients =sandwichObject.optJSONArray("ingredients");
                for (int i = 0; i < ingredients.length(); i++) {

                    ingredientsList.add(ingredients.optString(i));
                }

                sandwichDetails = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);


            } catch (JSONException e) {
                e.printStackTrace();
            }
            return sandwichDetails;
        }


}

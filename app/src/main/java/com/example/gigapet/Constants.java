package com.example.gigapet;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class Constants {


    public static final String GIGAPET_DEFAULT_NAME = "Charlie";
    public static Bitmap CURRENT_PET_BITMAP = null;

    public static int FOOD_TYPE_FRUIT = 0;
    public static int FOOD_TYPE_VEGGIE = 1;
    public static int FOOD_TYPE_CARB = 2;
    public static int FOOD_TYPE_PROTEIN = 3;
    public static int FOOD_TYPE_DAIRY = 4;
    public static int FOOD_TYPE_SWEET = 5;
    public static int MEAL_TYPE_ALL = 0;
    public static int MEAL_TYPE_BREAKFAST = 1;
    public static int MEAL_TYPE_LUNCH = 2;
    public static int MEAL_TYPE_DINNER = 3;
    public static boolean FIRST_CHILD_LOADED = false;
    public static SharedPreferences prefs;
    public static SharedPreferences.Editor editor;

    public static int[] ADD_FOOD_ARRAY = new int[6];
    public static String[] MEAL_TYPES = {"All Meals", "Breakfast", "Lunch", "Dinner"};
    public static String[] FOOD_TYPES = {"fruit", "vegetables", "carbs", "protein", "dairy", "treats"};

    public static String BASE_URL = "https://lambda-gigapet.herokuapp.com/";
    public static String PET_URL = BASE_URL + "api/pet";
    public static String REGISTER_URL = BASE_URL + "api/auth/register";
    public static String LOGIN_URL = BASE_URL + "api/auth/login";
    public static String CHILD_URL = BASE_URL + "api/child";
    public static String PARENT_URL = BASE_URL + "api/parent/";
    public static String PARENT_ENDING = "api/parent/";
    public static String FOOD_ENTRY_ENDING = "/entries";
    public static String FOOD_ENTRIES_UPDATE_URL = CHILD_URL + "/%d" + FOOD_ENTRY_ENDING;
    public static String FOOD_ENTRIES_ID_TIME = BASE_URL + CHILD_URL + "/%d/entries?time-span=%s";
    public static final String ADD_CHILD_URL = BASE_URL + PARENT_ENDING + "%d" + "/child";

    public static void setSharedPrefs(Context context){
        prefs = context.getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = prefs.edit();
    }

    public static Map<String, String> getHeaders() {
        Map<String, String> params = new HashMap<>();
        params.put("Authorization", Constants.prefs.getString("token", "default"));
        params.put("Content-Type", "application/json");
        return params;
    }

    public static void ClearFoodArray(){
        ADD_FOOD_ARRAY = new int[] {0,0,0,0,0,0};
    }


}

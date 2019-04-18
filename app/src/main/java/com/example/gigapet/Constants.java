package com.example.gigapet;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Constants {


    public static final String GIGAPET_DEFAULT_NAME = "Charlie";

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
    public static SharedPreferences prefs;
    public static SharedPreferences.Editor editor;

    public static String[] MEAL_TYPES = {"All Meals", "Breakfast", "Lunch", "Dinner"};
    public static String[] FOOD_TYPES = {"fruit", "vegetables", "carbs", "protein", "dairy", "treats"};

    public static String BASE_URL = "https://lambda-gigapet.herokuapp.com/";
   // public static String URL_ENDING = "/.json";
    public static String PET_URL = BASE_URL + "api/pet";
    public static String REGISTER_URL = BASE_URL + "api/auth/register";
    public static String LOGIN_URL = BASE_URL + "api/auth/login";
    public static String CHILD_URL = BASE_URL + "api/child";
    public static String PARENT_URL = BASE_URL + "api/parent/";
    public static String PARENT_ENDING = "api/parent/";
    public static String FOOD_ENTRIES_UPDATE_URL = BASE_URL + CHILD_URL + "time-span=%s";
    public static String FOOD_ENTRIES_ID_TIME = BASE_URL + CHILD_URL + "/%d/entries?time-span=%s";
    public static final String ADD_CHILD_URL = BASE_URL + PARENT_ENDING + "%d" + "/child";

    public static void setSharedPrefs(Context context){
        prefs = context.getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = prefs.edit();
    }


}

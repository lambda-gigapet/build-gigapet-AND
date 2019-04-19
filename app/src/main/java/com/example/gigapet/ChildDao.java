package com.example.gigapet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ChildDao {

    public static Child getCurrentChild() {
        return ChildRepo.getChildById(ChildRepo.getCurrentChildId());
    }

    public static void addChild(Child child) {
        ChildRepo.addChild(child);
        JSONObject requestBody = null;
        try {
            requestBody = new JSONObject(
                    (String.format("{\"name\":\"%s\",\"pet_name\":\"%s\",\"pet_experience\":%d,\"pet_id\":%d}",
                            child.getName(),
                            child.getGigapet().getName(),
                            child.getGigapet().getExp(),
                            child.getGigapet().getId())));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NetworkAdapter.httpRequest(
                String.format(
                        Constants.ADD_CHILD_URL,
                        Constants.prefs.getInt("parent_id", 0)),
                NetworkAdapter.POST,
                requestBody,
                Constants.getHeaders());
    }

    public static JSONObject getFoodHistory(int mealType, int childPos) {
        JSONObject jsonObject = null;
        String history = "{\"carbs\":[{\"id\": 1,\"name\": \"Porridge\",\"quantity\": 2,\"meal\": \"Breakfast\",\"category\": \"Carbs\",\"date_added\": \"2019--04-15\",\"date_update\": \"2019--04-15\",\"child_id\": 1 },{\"id\": 1,\"name\": \"Porridge\",\"quantity\": 2,\"meal\": \"Breakfast\",\"category\": \"Protein\",\"date_added\": \"2019--04-15\",\"date_update\": \"2019--04-15\",\"child_id\": 1 }],\"protein\": [{\"id\": 1,\"name\": \"Porridge\",\"quantity\": 4,\"meal\": \"Lunch\",\"category\": \"Carbs\",\"date_added\": \"2019--04-15\",\"date_update\": \"2019--04-15\",\"child_id\": 1 }],\"vegetables\": [{\"id\": 1,\"name\": \"Porridge\",\"quantity\": 2,\"meal\": \"Breakfast\",\"category\": \"Carbs\",\"date_added\": \"2019--04-15\",\"date_update\": \"2019--04-15\",\"child_id\": 1 }],\"fruits\": [{\"id\": 1,\"name\": \"Porridge\",\"quantity\": 2,\"meal\": \"Breakfast\",\"category\": \"Carbs\",\"date_added\": \"2019--04-15\",\"date_update\": \"2019--04-15\",\"child_id\": 1 }],\"dairy\": [{\"id\": 1,\"name\": \"Porridge\",\"quantity\": 2,\"meal\": \"Breakfast\",\"category\": \"Carbs\",\"date_added\": \"2019--04-15\",\"date_update\": \"2019--04-15\",\"child_id\": 1 }]}";
        try {
            jsonObject = new JSONObject(history);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //return NetworkAdapter.httpRequest(Constants.HISTORY_URL,NetworkAdapter.GET, null);

        return jsonObject;
    }

    public static ArrayList<Child> getChildren() {
        return ChildRepo.getChildren();
    }

    public static int getHighestId() {
        return ChildRepo.getHighestId();
    }

    public static String[] getChildrenNames() {
        return ChildRepo.getChildrenNames();
    }

    public static void removeChild(int pos) {
        NetworkAdapter.httpRequest(Constants.CHILD_URL + "/" + String.valueOf(pos) + "/", NetworkAdapter.DELETE, Constants.getHeaders());
    }

    public static void importChildrenFromDb() {
        int childId = 0;
        String childName = "";
        String petName = "";
        int petExp = 0;
        int petId = 0;
        String happyImg = "";
        String okImg = "";
        String sadImg = "";
        String sickImg = "";
        String eatingImg = "";
        JSONObject jsonObject;


        final String result = NetworkAdapter.httpRequest(
                Constants.PARENT_URL
                        + String.valueOf(
                        Parent.getId()),
                NetworkAdapter.GET, Constants.getHeaders());

        try {
            jsonObject = new JSONObject(result);
            try {
                JSONArray jsonArray = jsonObject.getJSONArray("childArray");
                if (jsonArray.isNull(0)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ChildDao.addChild(new Child("Default", 1));
                        }
                    }).start();

                } else {
                    ChildRepo.removeAllChildren();
                    for (int i = 0; i < jsonArray.length(); i++) {

                        try {
                            childId = jsonArray.getJSONObject(i).getInt("child_id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            childName = jsonArray.getJSONObject(i).getString("child_name");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            petName = jsonArray.getJSONObject(i).getString("pet_name");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            petExp = jsonArray.getJSONObject(i).getInt("pet_experience");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            petId = jsonArray.getJSONObject(i).getInt("pet_id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            happyImg = jsonArray.getJSONObject(i).getString("happy");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            okImg = jsonArray.getJSONObject(i).getString("ok");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            sadImg = jsonArray.getJSONObject(i).getString("sad");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            sickImg = jsonArray.getJSONObject(i).getString("sick");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            eatingImg = jsonArray.getJSONObject(i).getString("eating");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        ChildRepo.addChild(new Child(
                                childName,
                                childId,
                                new Gigapet(
                                        petName,
                                        petExp,
                                        petId,
                                        happyImg,
                                        okImg,
                                        sadImg,
                                        sickImg,
                                        eatingImg)));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public static void setCurrentChildId(int id) {
        ChildRepo.setCurrentChildById(id);
    }

    public static void AddFoodToDb(Food food){

        JSONObject requestBody = null;
        try {
            requestBody = new JSONObject(
                    (String.format("{\"name\":\"%s\",\"quanity\":\"%d\",\"meal\":%s\",\"category\":%s\",\"date_added\":%s\",\"date_updated\":%s\"}",
                            food.getName(),
                            food.getQuantity(),
                            food.getMeal(),
                            food.getCategory(),
                            food.getDateAdded(),
                            food.getDateUpdated())));
        } catch (JSONException e) {
            e.printStackTrace();
        }

       String url = String.format(Constants.FOOD_ENTRIES_UPDATE_URL, ChildDao.getCurrentChild().getId());
        NetworkAdapter.httpRequest(url, NetworkAdapter.POST, requestBody, Constants.getHeaders());
    }

    public static Child getChildByName(String childrenName) {
        return ChildRepo.getChildByName(childrenName);
    }

    public static void LoadFoodEntries() {
        int[] entries = new int[6];
        ArrayList<Food> foods = new ArrayList<>();

        int id = 0;
        String name = "";
        int quantity = 0;
        String meal = "";
        String category = "";
        String dateAdded = "";
        String dateUpdated = "";
        int childId = 0;


        String url = String.format(Constants.FOOD_ENTRIES_UPDATE_URL, ChildDao.getCurrentChild().getId());
        String result = NetworkAdapter.httpRequest(url, NetworkAdapter.GET, Constants.getHeaders());

        try {
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);

                id = jsonObject.getInt("id");
                name = jsonObject.getString("name");
                quantity = jsonObject.getInt("quantity");
                meal = jsonObject.getString("meal");
                category = jsonObject.getString("category");
                dateAdded = jsonObject.getString("date_added");
                dateUpdated = jsonObject.getString("date_updated");
                childId = jsonObject.getInt("child_id");

                foods.add(new Food(id,name,quantity,meal,category,dateAdded,dateUpdated,childId));
            }

            FoodRepo.addFoodList(foods);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static void CreateFoodFromIntArr(int[] addFoodArray) {
        for(int i = 0; i < 6; ++i){
           AddFoodToDb(new Food(
                   Constants.FOOD_TYPES[i],
                   Constants.MEAL_TYPES[Parent.getMealIndex()],
                   addFoodArray[i],
                   ChildDao.getCurrentChild().getId()));
        }
    }

    public static void loadFirstChild() {

        String firstChildName = Constants.prefs.getString("first_child_name", "Default");
        int firstChildId = Constants.prefs.getInt("first_child_id", 0);

        if(firstChildId != 0){
            Constants.FIRST_CHILD_LOADED = true;
        }
        addChild(new Child(firstChildName,firstChildId));
        setCurrentChildId(firstChildId);


    }

    public static void AddFood(int[] addFoodArray) {
        for(int i = 0; i < addFoodArray.length; i++){
            AddFoodToDb(new Food(Constants.FOOD_TYPES[i], Constants.MEAL_TYPES[Parent.getMealIndex()], addFoodArray[i], getCurrentChild().getId()));
            ChildRepo.addFood(i, addFoodArray[i]);
        }
    }
}
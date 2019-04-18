package com.example.gigapet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ChildDao {

    public static Child getCurrentChild(){
        return ChildRepo.getChildById(ChildRepo.getCurrentChildId());
    }

    public static void addChild(Child child) {
        ChildRepo.addChild(child);
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
    ChildRepo.removeChild(pos);
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

        final String result = NetworkAdapter.httpRequest(
                Constants.PARENT_URL
                        + String.valueOf(
                        Constants.prefs.getInt("parent_id", 0)),
                NetworkAdapter.GET, getHeaders());

        try {
            JSONObject jsonObject = new JSONObject(result);
            try {
                ChildRepo.removeAllChildren();
                JSONArray jsonArray = jsonObject.getJSONArray("childArray");
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

        public static Map<String,String> getHeaders(){
        Map<String,String> params = new HashMap<>();
        params.put("Authorization", Constants.prefs.getString("token", "default"));
        return params;
    }

    public static void setCurrentChildId(int id) {
        ChildRepo.setCurrentChildById(id);
    }

    public static Child getChildByName(String childrenName) {
        return ChildRepo.getChildByName(childrenName);
    }

}

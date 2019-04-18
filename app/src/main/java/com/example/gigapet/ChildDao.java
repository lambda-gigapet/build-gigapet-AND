package com.example.gigapet;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class ChildDao {

    public static Child getCurrentChild(){
        return ChildRepo.getChildById(Parent.getChildIndex());
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
}

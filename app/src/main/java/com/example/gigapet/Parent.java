package com.example.gigapet;

import java.util.ArrayList;

public class Parent {
    private static  int id;
    private static int mealIndex;
    private static String token;
    private static String name;



    public static int getMealIndex() {
        return mealIndex;
    }

    public static void setMealIndex(int mealIndex) {
        Parent.mealIndex = mealIndex;
    }

    public Parent(int id, String token) {
        this.id = id;
        this.token = token;
        this.mealIndex = 1;
        //ChildDao.loadFirstChild();
        loadChildren();
        GigapetDao.loadGigapets();
    }
    public static void loadChildren(){
        ChildDao.importChildrenFromDb();
    }

    public static void setId(int newId) {
        id = newId;
    }

    public static int getId() {
        return id;
    }


    public static String getName() {
        return name;
    }

    public static void setName(String newName) {
        name = newName;
    }


}

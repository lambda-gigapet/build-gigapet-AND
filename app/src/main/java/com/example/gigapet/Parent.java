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
        loadChildren();
        GigapetDao.loadGigapets();
        ChildDao.setCurrentChildId(ChildDao.getChildren().get(ChildDao.getChildren().size()-1).getId());
    }
    public static void loadChildren(){
        ChildDao.importChildrenFromDb();
    }

    public static String[] getChildrensNamesAsArray() {

        ArrayList<Child> children = ChildDao.getChildren();

        String[] names = new String[children.size()];
        for(int i = 0; i < children.size(); i++){
            names[i] = children.get(i).getName();
        }
        return names;
    }

    public static void setId(int newId) {
        id = newId;
    }

    public static int getId() {
        return id;
    }

    public static String getToken() {
        return token;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String newName) {
        name = newName;
    }

    public static void setToken(String token) {
        Parent.token = token;
    }

}

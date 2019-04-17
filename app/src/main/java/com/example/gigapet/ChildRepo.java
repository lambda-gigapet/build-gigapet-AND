package com.example.gigapet;

import java.util.ArrayList;

public class ChildRepo {
    private static ArrayList<Child> children = new ArrayList<>();
    private static int currentChildId;

    public ChildRepo(ArrayList<Child> children) {
        this.children = children;
        currentChildId = -1;
    }

    public static void setCurrentChildById(int id){
        currentChildId = id;
    }


    public static void addChild(Child child){
        children.add(child);
    }

    public static Child getChildById(int id){
        for(int i = 0; i < children.size(); i++){
            if(id == children.get(i).getId()){
                return children.get(i);
            }
        }
        return null;
    }

    public static int getCurrentChildId() {
        return currentChildId;
    }
}

package com.example.gigapet;

import java.util.ArrayList;

public class ChildDao {

    public static Child getCurrentChild(){
        return ChildRepo.getChildById(ChildRepo.getCurrentChildId());
    }

    public static void setCurrentChildById(int i) {
        ChildRepo.setCurrentChildById(i);
    }

    public static void addChild(Child child) {
        ChildRepo.addChild(child);
    }
}

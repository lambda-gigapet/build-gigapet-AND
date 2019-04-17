package com.example.gigapet;

import java.util.ArrayList;

public class Child {
    private String name;
    private int id;
    private int[] foodIntArr;
    Gigapet gigapet;


    public Child(String name, int id) {
        this(name, id, new Gigapet(Constants.GIGAPET_DEFAULT_NAME, 1));
    }

    public Child(String name, int id, Gigapet gigapet) {
        this.name = name;
        this.id = id;
        this.gigapet = gigapet;
        foodIntArr = new int[6];
    }

    public void setGigapet(Gigapet gigapet) {
        this.gigapet = gigapet;
    }

    public void addFood(int id, int amount) {
        foodIntArr[id] += amount;
    }

    public void removeFood(int id, int amount) {
        foodIntArr[id] = foodIntArr[id] - amount;
    }

    public int getFoodById(int id) {
        return foodIntArr[id];
    }

    public int[] getAllFood() {
        return foodIntArr;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gigapet getGigapet() {
        return gigapet;
    }
}

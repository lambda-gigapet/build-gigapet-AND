package com.example.gigapet;

import java.util.ArrayList;

public class Child {
    private String name;
    private int id;
    private ArrayList<Gigapet> gigapets;
    private int[] foodIntArr;
    private int currentGigapet = -1;

    public Child(String name, int id) {
        this.name = name;
        this.id = id;
        foodIntArr = new int[6];
        gigapets = new ArrayList<>();
    }

    public void addFood(int id, int amount){
        foodIntArr[id] += amount;
    }

    public void removeFood(int id, int amount){
        foodIntArr[id] = foodIntArr[id] - amount;
    }

    public int getFoodById(int id){
        return foodIntArr[id];
    }

    public int[] getAllFood(){
        return foodIntArr;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Gigapet> getGigapets() {
        return gigapets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGigapets(ArrayList<Gigapet> gigapets) {
        this.gigapets = gigapets;
    }

    public void addGigapet(Gigapet gigapet){
        gigapets.add(gigapet);
        currentGigapet = gigapets.size()-1;
    }

    public Gigapet getGigapetByPosition(int position){
        return gigapets.get(position);
    }

    public Gigapet getCurrentGigapet() {
        return gigapets.get(currentGigapet);
    }
}

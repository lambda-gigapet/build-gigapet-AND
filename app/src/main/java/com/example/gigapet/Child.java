package com.example.gigapet;

import java.util.ArrayList;

public class Child {
    private String name;
    private String id;
    private ArrayList<Gigapet> gigapets;

    public Child(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
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
    }

    public Gigapet getGigapetByPosition(int position){
        return gigapets.get(position);
    }
}

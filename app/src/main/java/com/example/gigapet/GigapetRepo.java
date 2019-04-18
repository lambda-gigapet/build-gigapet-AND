package com.example.gigapet;

import java.util.ArrayList;

public class GigapetRepo {
    static  ArrayList<Gigapet> gigapets = new ArrayList<>();

    public static ArrayList<Gigapet> getGigapets() {
        return gigapets;
    }

    public static void addPetArr(ArrayList<Gigapet> loadPets) {
        gigapets.addAll(loadPets);
    }

    public void setGigapets(ArrayList<Gigapet> newGigapets) {
        gigapets = newGigapets;
    }


}

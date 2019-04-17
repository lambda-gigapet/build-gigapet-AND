package com.example.gigapet;

import java.util.ArrayList;

public class GigapetRepo {
    private static ArrayList<Gigapet> gigapets = new ArrayList<>();
    private static int currentGigapetIndex;

    public GigapetRepo(ArrayList<Gigapet> pets) {
        gigapets = pets;
    }

    public GigapetRepo(){
        gigapets = new ArrayList<>();
    }

    public static ArrayList<Gigapet> getGigapets() {
        return gigapets;
    }

    public static void setGigapets(ArrayList<Gigapet> pets) {
        gigapets = pets;
    }

    public static Gigapet getCurrentGigapet() {
        return ChildDao.getCurrentChild().getCurrentGigapet();
    }

    public static void setCurrentGigapetIndex(int index) {
        currentGigapetIndex = index;
    }

    public static void addGigapet(Gigapet gigapet) {
        gigapets.add(gigapet);
    }
}

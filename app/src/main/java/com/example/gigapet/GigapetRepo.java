package com.example.gigapet;

import java.util.ArrayList;

public class GigapetRepo {
    static ArrayList<Gigapet> gigapets = new ArrayList<>();

    public static ArrayList<Gigapet> getGigapets() {
        return gigapets;
    }

    public static void addPetArr(ArrayList<Gigapet> loadPets) {
        gigapets.addAll(loadPets);
    }

    public static Gigapet getPetById(int id) {
        for (int i = 0; i < gigapets.size(); i++) {
            if (gigapets.get(i).getId() == id) {
                return gigapets.get(i);
            }
        }
        return gigapets.get(0);
    }

    public static String getMoodImage(int state, int id) {
        switch (state) {
            case 0:
                ChildDao.getCurrentChild().getGigapet().addExp();
                return getPetById(id).getHappyImg();
            case 1:
                ChildDao.getCurrentChild().getGigapet().addExp();
                return getPetById(id).getOkImg();
            case 2:
                ChildDao.getCurrentChild().getGigapet().addExp();
                return getPetById(id).getSadImg();
            case 3:
                ChildDao.getCurrentChild().getGigapet().addExp();
                return getPetById(id).getSickImg();
            case 4:
                ChildDao.getCurrentChild().getGigapet().addExp();
                return getPetById(id).getEatingImg();
        }

        return getPetById(id).getHappyImg();
    }

    public void setGigapets(ArrayList<Gigapet> newGigapets) {
        gigapets = newGigapets;
    }


}

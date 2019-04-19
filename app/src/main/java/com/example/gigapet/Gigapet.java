package com.example.gigapet;

public class Gigapet {
    private String name;
    private int id;
    private int exp;
    private String description;
    private String species;
    private String happyImg;
    private String okImg;
    private String sadImg;
    private String sickImg;
    private String eatingImg;
    private int state;

    public Gigapet(String name, int id) {
        this.name = name;
        this.id = id;
        this.exp = 0;
    }

    public Gigapet(int petId,String species,String description,String happyUrl,String okUrl,String sadUrl,String sickUrl,String eatingUrl){
        this.id = petId;
        this.species = species;
        this.description = description;
        this.happyImg = happyUrl;
        this.okImg = okUrl;
        this.sadImg = sadUrl;
        this.sickImg = sickUrl;
        this.eatingImg = eatingUrl;
    }

    public Gigapet(String name, int exp, int id, String happyImg, String okImg, String sadImg, String sickImg, String eatingImg) {
        this.name = name;
        this.id = id;
        this.exp = exp;
        this.happyImg = happyImg;
        this.okImg = okImg;
        this.sadImg = sadImg;
        this.sickImg = sickImg;
        this.eatingImg = eatingImg;
    }



    public void feed(int foodType) {
            state = foodType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }


    public String getName() {
        return name;
    }

    public int getExp() {
        return exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHappyImg() {
        return happyImg;
    }

    public String getOkImg() {
        return okImg;
    }

    public String getSadImg() {
        return sadImg;
    }
    public void addExp(){
        exp = exp + 1;
    }

    public String getSickImg() {
        return sickImg;
    }

    public String getEatingImg() {
        return eatingImg;
    }

}

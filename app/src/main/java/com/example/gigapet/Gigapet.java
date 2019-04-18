package com.example.gigapet;

public class Gigapet {
    private String name;
    private int id;
    private int exp;
    private String happyImg;
    private String okImg;
    private String sadImg;
    private String sickImg;
    private String eatingImg;

    public Gigapet(String name, int id) {
        this.name = name;
        this.id = id;
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
        switch (foodType) {
            case 1:
                eatHealthyFood();
                break;
            case 2:
                eatHealthyFood();
                break;
            case 3:
                eatHealthyFood();
                break;
            case 4:
                eatHealthyFood();
                break;
            case 5:
                eatHealthyFood();
                break;
            case 6:
                eatSweets();
                break;
        }

    }

    private void eatHealthyFood() {

    }
    private void eatSweets() {

    }
    public void setName(String name) {
        this.name = name;
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

    public void setHappyImg(String happyImg) {
        this.happyImg = happyImg;
    }

    public String getOkImg() {
        return okImg;
    }

    public void setOkImg(String okImg) {
        this.okImg = okImg;
    }

    public String getSadImg() {
        return sadImg;
    }

    public void setSadImg(String sadImg) {
        this.sadImg = sadImg;
    }

    public String getSickImg() {
        return sickImg;
    }

    public void setSickImg(String sickImg) {
        this.sickImg = sickImg;
    }

    public String getEatingImg() {
        return eatingImg;
    }

    public void setEatingImg(String eatingImg) {
        this.eatingImg = eatingImg;
    }
}

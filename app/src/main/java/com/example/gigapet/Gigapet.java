package com.example.gigapet;

public class Gigapet {
    private String name;
    private int id;
    private int state;
    private int exp;
    private int[] imageResource;

    public Gigapet(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void feed(int foodType){
        switch (foodType){
            case 1: eatHealthyFood();
                break;
            case 2: eatHealthyFood();
                break;
            case 3: eatHealthyFood();
                break;
            case 4: eatHealthyFood();
                break;
            case 5: eatHealthyFood();
                break;
            case 6: eatSweets();
                break;
        }

    }

    private void eatHealthyFood(){

    }

    private void eatSweets(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setImageResource(int[] imageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getExp() {
        return exp;
    }

    public int[] getImageResource() {
        return imageResource;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

package com.example.gigapet;

import android.graphics.drawable.Drawable;

import java.util.Random;

public class FoodIcons {
    private int[] imageResources;
    private int numberOfFood;
    private int imageBackground;

    public FoodIcons(int id, int amount) {
        imageResources = DrawableResolver.getDrawableId(id);
        imageBackground = DrawableResolver.getDrawableIcon(id);
        numberOfFood = amount;
    }

    public int getNumberOfFood() {
        return numberOfFood;
    }

    public int getRandomImage(){
        Random random = new Random();
        return(imageResources[random.nextInt(imageResources.length)]);
    }

    public int getImageBackground() {
        return imageBackground;
    }
}

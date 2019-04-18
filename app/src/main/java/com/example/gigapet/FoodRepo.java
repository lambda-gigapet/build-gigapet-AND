package com.example.gigapet;

import java.util.ArrayList;
import java.util.Random;

public class FoodRepo {

    static ArrayList<Food> foods = new ArrayList<>();

    public FoodRepo(){
        addFoodArr(mockData(20));
    }

    public static Food getFoodById(int id) {
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getId() == id) {
                return foods.get(id);
            }
        }
        return null;
    }

    public void addFoodArr(ArrayList<Food> addedFoods){
        foods.addAll(addedFoods);
    }
    public static void addFood(Food food) {
        foods.add(food);
    }

    public static void clearFoods(){
        foods.clear();
    }

    public static ArrayList<Food> getFoods() {
        return foods;
    }

    public static ArrayList<Food> mockData(int amount){
        int counter = 1;
        Random random = new Random();
        ArrayList<Food> foods = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            //int id, String name, int quantity, String meal, String category, String dateAdded, String dateUpdated, int childId
            foods.add(new Food(
                    counter,
                    "FakeFood",
                    random.nextInt(3),
                    getRandomFoodType(random.nextInt(5)),
                            "2019--04-15",
                            "2019--04-15",
                            ChildDao.getCurrentChild().getId()));
        }

        return foods;
    }

    public static String getRandomFoodType(int randomNum){
        return Constants.FOOD_TYPES[randomNum];
    }
}


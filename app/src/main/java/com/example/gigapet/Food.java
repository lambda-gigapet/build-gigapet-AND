package com.example.gigapet;

public class Food {

    private int id;
    private String name;
    private int quantity;
    private String meal;
    private String category;
    private String dateAdded;
    private String dateUpdated;
    private int childId;

    public Food(String category, String meal, int quantity, int childId){
        this(1,"name", quantity, meal, category, "2019--04-15", "2019--04-16", childId);
    }

    public Food(int id, String name, int quantity, String meal, String category, String dateAdded, int childId) {
        this(id,name,quantity,meal,category,dateAdded,dateAdded,childId);
    }
    public Food(int id, String name, int quantity, String meal, String category, String dateAdded, String dateUpdated, int childId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.meal = meal;
        this.category = category;
        this.dateAdded = dateAdded;
        this.dateUpdated = dateUpdated;
        this.childId = childId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }
}

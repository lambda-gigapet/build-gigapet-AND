package com.example.gigapet;

import java.util.ArrayList;

public class Parent {
    private ArrayList<Child> children;
    private int id;
    private String token;
    private String name;
    private int childIndex;

    public int getChildIndex() {
        return childIndex;
    }

    public void setChildIndex(int childIndex) {
        this.childIndex = childIndex;
    }

    public Parent(int id, String token) {
        this.id = id;
        this.token = token;
        children = new ArrayList<>();
    }

    public void addChild(Child child){
        children.add(child);
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeChild(int position){
        children.remove(position);
    }
}

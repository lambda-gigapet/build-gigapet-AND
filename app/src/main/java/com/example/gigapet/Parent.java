package com.example.gigapet;

import java.util.ArrayList;

public class Parent {
    private ArrayList<Child> children;
    private int id;
    private String token;
    private String name;

    public Parent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addChild(Child child){
        children.add(child);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
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

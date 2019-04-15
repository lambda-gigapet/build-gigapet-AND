package com.example.gigapet;

public class Gigapet {
    private String name;
    private String uniqueId;
    private int state;
    private int exp;
    private int repoId;
    private int[] imageResource;

    public Gigapet(String name, String uniqueId) {
        this.name = name;
        this.uniqueId = uniqueId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setRepoId(int repoId) {
        this.repoId = repoId;
    }

    public void setImageResource(int[] imageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public int getExp() {
        return exp;
    }

    public int getRepoId() {
        return repoId;
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

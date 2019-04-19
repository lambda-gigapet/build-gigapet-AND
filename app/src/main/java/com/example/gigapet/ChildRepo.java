package com.example.gigapet;

import java.util.ArrayList;

public class ChildRepo {
    private static ArrayList<Child> children = new ArrayList<>();
    private static int currentChildId = 0;

    public ChildRepo(ArrayList<Child> children) {
        this.children = children;
        currentChildId = 0;
    }

    public static void addChild(Child child){
        children.add(child);
    }

    public static Child getChildById(int id){
        for(int i = 0; i < children.size(); i++){
            if(id == children.get(i).getId()){
                return children.get(i);
            }
        }
        return children.get(0);
    }

    public static ArrayList<Child> getChildren() {
    return children;
    }

   public static int getHighestId(){
        int result = 0;
       for (Child child:children) {
           if(child.getId() > result){
               result = child.getId();
           }
       }
       return result;
   }

    public static String[] getChildrenNames() {
        String[] names = new String[children.size()];
        int i = 0;
        for (Child child:children) {
            names[i] = child.getName();
            i++;
        }
        return names;
    }

    public static void removeChild(int pos) {
        children.remove(pos);
    }

    public static void removeAllChildren() {
        children.clear();
    }

    public static void setCurrentChildById(int id) {
        currentChildId = id;
    }

    public static void setChildren(ArrayList<Child> children) {
        ChildRepo.children = children;
    }

    public static int getCurrentChildId() {
        return currentChildId;
    }

    public static void setCurrentChildId(int currentChildId) {
        ChildRepo.currentChildId = currentChildId;
    }

    public static Child getChildByName(String childrenName) {
        for(int i = 0; i < children.size(); i++){
            if(childrenName == children.get(i).getName()){
                return children.get(i);
            }
        }
        return null;
    }

    public static void addFood(int type, int amount) {
        getChildById(getCurrentChildId()).addFood(type, amount);
    }
}

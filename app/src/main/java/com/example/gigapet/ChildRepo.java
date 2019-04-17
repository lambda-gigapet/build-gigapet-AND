package com.example.gigapet;

import java.util.ArrayList;

public class ChildRepo {
    private static ArrayList<Child> children = new ArrayList<>();

    public ChildRepo(ArrayList<Child> children) {
        this.children = children;
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
        return null;
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
}

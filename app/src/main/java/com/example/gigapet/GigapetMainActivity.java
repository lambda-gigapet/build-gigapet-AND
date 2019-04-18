package com.example.gigapet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GigapetMainActivity extends AppCompatActivity {


    FoodIconAdapter listAdapter;
    RecyclerView recyclerView;
    ImageView sweetsView;
    Parent parent;
    Child child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gigapet_main);
        sweetsView = findViewById(R.id.iv_unhealthy_food_icon);

/*        parent = new Parent(1, "token");
        child = new Child("Steve", 1, new Gigapet("Bob", 1));
        ChildDao.addChild(child);
        ChildDao.setCurrentChildById(1);
        child.addFood(1, 2);
        child.addFood(3, 4);
        child.addFood(5, 5);
        ChildDao.addChild(child);
        ChildDao.addChild(new Child("Sarah", 2));*/

        recyclerView = findViewById(R.id.food_icon_recycler_view);
        listAdapter = new FoodIconAdapter();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(layoutManager);
        ImageView iv = findViewById(R.id.iv_options_sidebar_button);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ParentMainActivity.class);
               startActivity(intent);
            }
        });
        checkForSweets();

        sweetsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildDao.getCurrentChild().removeFood(Constants.FOOD_TYPE_SWEET, 1);
                checkForSweets();
            }
        });
    }

    public Map<String,String> getHeaders(){
        Map<String,String> params = new HashMap<String,String>();
        params.put("Authorization", Constants.prefs.getString("token", "default"));
        return params;
    }

    private void checkForSweets(){
        if(ChildDao.getCurrentChild().getFoodById(Constants.FOOD_TYPE_SWEET) > 0){
            recyclerView.setVisibility(View.GONE);
            sweetsView.setVisibility(View.VISIBLE);
        }else{
            sweetsView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    private void updateGigapet(){

    }
}


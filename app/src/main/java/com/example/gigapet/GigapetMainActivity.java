package com.example.gigapet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GigapetMainActivity extends AppCompatActivity {


    FoodIconAdapter listAdapter;
    RecyclerView recyclerView;
    ImageView sweetsView;
    static ImageView gigapetImage;
    static TextView gigapetName;
    static TextView gigapetLvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gigapet_main);
        sweetsView = findViewById(R.id.iv_unhealthy_food_icon);
        gigapetImage = findViewById(R.id.iv_gigapet);
        gigapetLvl = findViewById(R.id.tv_gigapet_lvl);
        gigapetName = findViewById(R.id.tv_gigapet_name);

        recyclerView = findViewById(R.id.food_icon_recycler_view);
        listAdapter = new FoodIconAdapter(this);
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
                updateGigapet();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkForSweets();
        updateGigapet();
        gigapetImage.setImageBitmap(Constants.CURRENT_PET_BITMAP);
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

    public static void updateGigapet() {
        new loadGigapet().execute();
        gigapetImage.setImageBitmap(Constants.CURRENT_PET_BITMAP);
        gigapetName.setText(ChildDao.getCurrentChild().gigapet.getName());
        gigapetLvl.setText("Lvl - " +String.valueOf(ChildDao.getCurrentChild().gigapet.getExp()));
    }
}


final class loadGigapet extends AsyncTask<Void,Void, Bitmap>{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        Constants.CURRENT_PET_BITMAP = bitmap;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        Bitmap result = GigapetDao.bitmapFromURL(
                GigapetRepo.getMoodImage(
                ChildDao.getCurrentChild().gigapet.getState(),
                ChildDao.getCurrentChild().gigapet.getId()));
        return result;
    }
}


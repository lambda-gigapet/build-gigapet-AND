package com.example.gigapet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GigapetMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gigapet_main);

        ImageView iv = findViewById(R.id.iv_options_sidebar_button);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ParentMainActivity.class);
                startActivity(intent);
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

                final JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject("{\"name\":\"BrandonTest\",\"email\":\"testemail3142@email.com\",\"username\":\"BrandonTest3461\",\"password\":\"password123\"}");
                    String token = NetworkAdapter.httpRequest("https://lambda-gigapet.herokuapp.com/api/auth/register",NetworkAdapter.POST, jsonObject);
                    Log.i("test3", token);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }
}

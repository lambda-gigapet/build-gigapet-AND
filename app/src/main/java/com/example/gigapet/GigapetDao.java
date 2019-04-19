package com.example.gigapet;

import android.arch.lifecycle.ViewModelProvider;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class GigapetDao {

    public static void loadGigapets() {

        int petId = 0;
        String species = "";
        String description = "";
        String happyUrl = "";
        String okUrl = "";
        String sadUrl = "";
        String sickUrl = "";
        String eatingUrl = "";

        new Thread(new Runnable() {
            @Override
            public void run() {
                String results = NetworkAdapter.httpRequest(Constants.PET_URL, NetworkAdapter.GET, Constants.getHeaders());
                try {
                    int petId = 0;
                    String species = "";
                    String description = "";
                    String happyUrl = "";
                    String okUrl = "";
                    String sadUrl = "";
                    String sickUrl = "";
                    String eatingUrl = "";

                    ArrayList<Gigapet> loadPets = new ArrayList<Gigapet>();

                    JSONArray jsonArray = new JSONArray(results);

                    for (int i = 0; i < jsonArray.length(); ++i) {
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        try {
                            petId = jsonObject.getInt("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            species = jsonObject.getString("species");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            description = jsonObject.getString("description");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            happyUrl = jsonObject.getString("happy");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            okUrl = jsonObject.getString("ok");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            sadUrl = jsonObject.getString("sad");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            sickUrl = jsonObject.getString("sick");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            eatingUrl = jsonObject.getString("eating");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        loadPets.add(new Gigapet(petId,species,description,happyUrl,okUrl,sadUrl,sickUrl,eatingUrl));
                    }
                    GigapetRepo.addPetArr(loadPets);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public static Bitmap bitmapFromURL(String imageURl) {
        Bitmap image = null;

        try {
            URL url = new URL(imageURl);
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }


}

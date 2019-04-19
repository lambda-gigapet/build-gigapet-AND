package com.example.gigapet;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class FoodIconAdapter extends RecyclerView.Adapter<FoodIconAdapter.ViewHolder> {

    ArrayList<FoodIcons> foodIcons;
    Activity activity;
    public FoodIconAdapter(Activity activity) {
        this.activity = activity;
        foodIcons = new ArrayList<>();
        int[] foodAmountArr = ChildDao.getCurrentChild().getAllFood();
        for (int j = 0; j < 5; ++j) {
            foodIcons.add(new FoodIcons(j, foodAmountArr[j]));
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Context context;
        ImageView ivFoodImage;
        ImageView ivFoodBackground;
        TextView tvFoodAmount;
        View vParentView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoodImage = itemView.findViewById(R.id.iv_food_icon_image);
            tvFoodAmount = itemView.findViewById(R.id.tv_food_amount);
            ivFoodBackground = itemView.findViewById(R.id.iv_food_icon_background);
            vParentView = itemView.findViewById(R.id.recycler_view_item);
        }

        @Override
        public void onClick(View v) {

        }
    }

    @NonNull
    @Override
    public FoodIconAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_icon_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodIconAdapter.ViewHolder viewHolder, int i) {
        final FoodIcons data = foodIcons.get(i);

        foodIcons.clear();
       int[] foodAmountArr = ChildDao.getCurrentChild().getAllFood();
        for (int j = 0; j < 5; ++j) {
            foodIcons.add(new FoodIcons(j, foodAmountArr[j]));
        }



        viewHolder.tvFoodAmount.setText(String.valueOf(data.getNumberOfFood()));
        viewHolder.ivFoodImage.setImageResource(data.getRandomImage());
        final int position = i++;
        viewHolder.ivFoodBackground.setImageResource(data.getImageBackground());
        viewHolder.vParentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ChildDao.getCurrentChild().getFoodById(position) > 0) {
                    ChildDao.getCurrentChild().removeFood(position, 1);
                    ChildDao.getCurrentChild().getGigapet().feed(position);
                    foodIcons.clear();
                    int[] foodAmountArr = ChildDao.getCurrentChild().getAllFood();
                    for (int j = 0; j < 5; ++j) {
                        foodIcons.add(new FoodIcons(j, foodAmountArr[j]));
                    }

                    new Animations(activity).ItemTap(viewHolder.vParentView);
                    GigapetMainActivity.updateGigapet();
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.foodIcons.size();
    }
}

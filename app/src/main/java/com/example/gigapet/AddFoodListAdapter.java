package com.example.gigapet;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AddFoodListAdapter extends RecyclerView.Adapter<AddFoodListAdapter.ViewHolder> {

    public AddFoodListAdapter() {
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        ImageView ivMinusButton;
        ImageView ivPlusButton;
        ImageView ivFoodImage;
        ImageView ivFoodBackground;
        TextView tvFoodAmount;
        View vParentView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoodBackground = itemView.findViewById(R.id.iv_food);
            ivFoodImage = itemView.findViewById(R.id.iv_food_icon);
            tvFoodAmount = itemView.findViewById(R.id.tv_num);
            ivMinusButton = itemView.findViewById(R.id.iv_button_food_minus);
            ivPlusButton = itemView.findViewById(R.id.iv_button_food_plus);
            vParentView = itemView.findViewById(R.id.recycler_view_item_add_food);
        }
    }

    @NonNull
    @Override
    public AddFoodListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_add_item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AddFoodListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvFoodAmount.setText(String.valueOf(Constants.ADD_FOOD_ARRAY[i]));
        viewHolder.ivFoodImage.setImageResource(DrawableResolver.getDrawableImageIcon(i));
        viewHolder.ivFoodBackground.setImageResource(DrawableResolver.getDrawableIcon(i));
        final int position = i;
        viewHolder.ivMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Constants.ADD_FOOD_ARRAY[position] > 0) {
                    Constants.ADD_FOOD_ARRAY[position]--;
                    viewHolder.tvFoodAmount.setText(String.valueOf(Constants.ADD_FOOD_ARRAY[position]));
                }
                notifyDataSetChanged();
            }
        });
        viewHolder.ivPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.ADD_FOOD_ARRAY[position]++;
                viewHolder.tvFoodAmount.setText(String.valueOf(Constants.ADD_FOOD_ARRAY[position]));
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
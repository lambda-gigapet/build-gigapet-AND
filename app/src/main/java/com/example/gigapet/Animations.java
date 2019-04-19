package com.example.gigapet;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Animations {
    Activity activity;

    public Animations(Activity activity){
        this.activity = activity;
    }

    public void ItemTap(View v){
        Animation anim = AnimationUtils.loadAnimation(activity, R.anim.item_anim_slide_up);
        anim.setDuration(200);
        v.startAnimation(anim);
    }
}

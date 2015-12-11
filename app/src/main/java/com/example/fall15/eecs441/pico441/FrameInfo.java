package com.example.fall15.eecs441.pico441;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by aozga on 15/11/24.
 */
public class FrameInfo {

    public final Step left;
    public final Step right;

    // Units: # of beats.
    public final double duration; // TODO: make this a rational/fractional number.

    FrameInfo(Step left_, Step right_, double duration_) {
        left = left_;
        right = right_;
        duration = duration_;
    }

}

package com.example.fall15.eecs441.pico441;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;

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

    Drawable generateDrawable() {

        // TODO: make foot instead of oval
        // TODO: move foot around the frame based on the coords
        // TODO: rotate foot based on angle

        // TODO: make a drawable with two shapes (ie: feet).

        // TODO: do something with the duration.

        Shape s = new OvalShape();

        // TODO: when we actually run this, no shape is visible. Why?
        // TODO: Also, the button disappears. Did it get moved off the screen?

        ShapeDrawable sd = new ShapeDrawable(s);

        // sd.setIntrinsicWidth(left.x * 100);

        return sd;
    }
}

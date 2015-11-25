package com.example.fall15.eecs441.pico441;

/**
 * Created by aozga on 15/11/24.
 */
public class Step {

    // Units: hip-widths / 1000.
    // Note that the foot size is about 2/3 of a hip-width.
    // TODO: fact check that ratio.
    final int x;
    final int y;

    // A value in the range [0,INT_MAX],
    // normalized so INT_MAX is equal to 2pi.
    final int theta;

    Step(int x_, int y_, int theta_) {
        x = x_;
        y = y_;
        theta = theta_;
    }
}
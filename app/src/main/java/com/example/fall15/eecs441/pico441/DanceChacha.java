package com.example.fall15.eecs441.pico441;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanceChacha extends AppCompatActivity {

    final int min_bpm = 110;
    final int max_bpm = 130;
    final int default_bpm = 120;
    final int ms_to_sec = 1000;

    // TODO: use a better data structure (non-resizable array?)
    List<FrameInfo> DanceSteps = Arrays.asList(
            new FrameInfo(new Step(1,0,0), new Step(0,0,0), 0.5),
            new FrameInfo(new Step(2,0,0), new Step(0,0,0), 1.0),
            new FrameInfo(new Step(3,0,0), new Step(0,0,0), 1.5)
    );

    AnimationDrawable generateStepsAnimation(List<FrameInfo> steps, int bpm) {
        AnimationDrawable anim = new AnimationDrawable();

        for(FrameInfo frame : steps) {
            anim.addFrame(generateDrawable(frame), (int) (ms_to_sec * 60 / bpm * frame.duration));
        }

        return anim;
    }

//    protected AnimationDrawable getDelayAnimation(AnimationDrawable old, int new_bpm){
//        AnimationDrawable output = new AnimationDrawable();
//
//        for(int i = 0 ; i < old.getNumberOfFrames() ; i++)
//        {
//            int old_duration = old.getDuration(i);
//            output.addFrame(old.getFrame(i), ms_to_sec * 60 / new_bpm);
//        }
//        output.setOneShot(false);
//        return output;
//    }

    Drawable generateDrawable(FrameInfo f) {

        // TODO: make foot instead of oval
        // TODO: move foot around the frame based on the coords
        // TODO: rotate foot based on angle

        // TODO: make a drawable with two shapes (ie: feet).

        // TODO: do something with the duration.

        // TODO: when we actually run this, no shape is visible. Why?
        // TODO: Also, the button disappears. Did it get moved off the screen?

//        Shape s = new OvalShape();
//        ShapeDrawable sd = new ShapeDrawable(s);
//
//        sd.setIntrinsicWidth(left.x * 100);
//        return sd;

        ImageView stepView = (ImageView) findViewById(R.id.arrow_img_view);
        AnimationDrawable oldAnim = (AnimationDrawable) stepView.getDrawable();
        Drawable frame = oldAnim.getFrame(0);

        return frame;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance_chacha);

        ImageView stepView = (ImageView) findViewById(R.id.arrow_img_view);
        stepView.setBackgroundResource(R.drawable.arrow_anim_file);

        final AnimationDrawable frameAnimation = (AnimationDrawable) stepView.getBackground();

        frameAnimation.start();

        final Button button = (Button) findViewById(R.id.tempo_btn);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageView arrow_img = (ImageView) findViewById(R.id.arrow_img_view);

                AnimationDrawable currentAnimation = (AnimationDrawable) arrow_img.getBackground();
                currentAnimation.stop();

                final AnimationDrawable newAnimation = generateStepsAnimation(DanceSteps, default_bpm);
                arrow_img.setBackground(newAnimation);
//                stepView.setImageDrawable(newAnimation); // TODO: is this bad?

                newAnimation.start();
            }
        });
    }
}

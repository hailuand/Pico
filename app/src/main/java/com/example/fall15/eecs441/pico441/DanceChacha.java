package com.example.fall15.eecs441.pico441;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DanceChacha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance_chacha);

        ImageView arrow_img = (ImageView) findViewById(R.id.arrow_img_view);
        // Place animation on screen
        arrow_img.setBackgroundResource(R.drawable.arrow_anim_file);

        final AnimationDrawable frameAnimation = (AnimationDrawable) arrow_img.getBackground();
        // Start animation
        frameAnimation.start();
        // Button responsible for changing tempo
        final Button tempoButton = (Button) findViewById(R.id.tempo_btn);
        // When clicked, tempoButton will change animation speed and metronome beat
        tempoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageView arrow_img = (ImageView) findViewById(R.id.arrow_img_view);
                AnimationDrawable currentAnimation = (AnimationDrawable) arrow_img.getBackground();
                // Create a new animation with a modified delay factor
                final AnimationDrawable newAnimation = setAnimationDelay(currentAnimation, 2);
                // Stop current animation and place set new animation on screen
                currentAnimation.stop();
                arrow_img.setBackground(newAnimation);

                newAnimation.start();

            }
        });
    }
    // Modify the AnimationDrawable it's delay by a factor of delayFactor
    private AnimationDrawable setAnimationDelay(AnimationDrawable currentAnimation, int delayFactor){
        AnimationDrawable output = new AnimationDrawable();
        for(int i = 0 ; i < currentAnimation.getNumberOfFrames() ; i++)
        {
            int old_duration = currentAnimation.getDuration(i);
            output.addFrame(currentAnimation.getFrame(i), old_duration * delayFactor);
        }
        output.setOneShot(false);
        return output;
    }

}

package com.example.fall15.eecs441.pico441;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DanceChacha extends AppCompatActivity {

    final double fourFourCount = 2.0;
    final double halfFourCount = 0.5;
    double currentState = 2.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance_chacha);

        ImageView step = (ImageView) findViewById(R.id.basic_chacha_step);
        // Place animation on screen
        step.setBackgroundResource(R.drawable.chacha_basic_anim);



        final AnimationDrawable frameAnimation = (AnimationDrawable) step.getBackground();
        // Start animation
        frameAnimation.start();
        // Button responsible for changing tempo
        final Button tempoButton = (Button) findViewById(R.id.tempo_btn);
        // When clicked, tempoButton will change animation speed and metronome beat
        tempoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("HI GUYS");
                ImageView stepAnimation = (ImageView) findViewById(R.id.basic_chacha_step);
                AnimationDrawable currentAnimation = (AnimationDrawable) stepAnimation.getBackground();
                // Create a new animation with a modified delay factor
                final AnimationDrawable newAnimation;
                if(currentState == fourFourCount) {
                    currentState = halfFourCount;
                    newAnimation = halfCount(currentAnimation);
                }
                else{
                    currentState = fourFourCount;
                    newAnimation = doubleCount(currentAnimation);
                }
                // Stop current animation and place set new animation on screen
                currentAnimation.stop();
                stepAnimation.setBackground(newAnimation);
                newAnimation.start();
            }
        });
    }

    private AnimationDrawable doubleCount(AnimationDrawable currentAnimation){
        AnimationDrawable output = new AnimationDrawable();
        for(int i = 0 ; i < currentAnimation.getNumberOfFrames() ; i++)
        {
            int old_duration = currentAnimation.getDuration(i);
            output.addFrame(currentAnimation.getFrame(i), old_duration * 2);
        }
        output.setOneShot(false);
        return output;
    }

    private AnimationDrawable halfCount(AnimationDrawable currentAnimation){
        AnimationDrawable output = new AnimationDrawable();
        for(int i = 0 ; i < currentAnimation.getNumberOfFrames() ; i++)
        {
            int old_duration = currentAnimation.getDuration(i);
            output.addFrame(currentAnimation.getFrame(i), old_duration / 2);
        }
        output.setOneShot(false);
        return output;
    }

}

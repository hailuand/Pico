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
        arrow_img.setBackgroundResource(R.drawable.arrow_anim_file);

        final AnimationDrawable frameAnimation = (AnimationDrawable) arrow_img.getBackground();

        frameAnimation.start();

        final Button button = (Button) findViewById(R.id.tempo_btn);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageView arrow_img = (ImageView) findViewById(R.id.arrow_img_view);
                AnimationDrawable currentAnimation = (AnimationDrawable) arrow_img.getBackground();

                final AnimationDrawable newAnimation = getDelayAnimation(currentAnimation);

                currentAnimation.stop();

                arrow_img.setBackground(newAnimation);

                newAnimation.start();

            }
        });
    }

    private AnimationDrawable getDelayAnimation(AnimationDrawable old){
        AnimationDrawable output = new AnimationDrawable();
        for(int i = 0 ; i < old.getNumberOfFrames() ; i++)
        {
            int old_duration = old.getDuration(i);
            output.addFrame(old.getFrame(i), old_duration * 2);
        }
        output.setOneShot(false);
        return output;
    }

}

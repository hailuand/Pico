package com.example.fall15.eecs441.pico441;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static public String kEXTRA_MESSAGE = "com.example.fall15.eecs441.pico441.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");
        TextView tag = (TextView)  findViewById(R.id.tagline);
        tag.setTypeface(typeface);
    }

    public void letsDance(View view) {
        Intent intent = new Intent(this, DanceSelections.class);
        startActivity(intent);
    }

}

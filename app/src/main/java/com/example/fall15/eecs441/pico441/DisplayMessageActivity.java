package com.example.fall15.eecs441.pico441;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        // Retrieve Intent that got us to this page
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.kEXTRA_MESSAGE);
        // Create TextView
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        // Set text view as the activity layout
        setContentView(textView);
    }
}

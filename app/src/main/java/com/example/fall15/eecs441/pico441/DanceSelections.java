package com.example.fall15.eecs441.pico441;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DanceSelections extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance_selections);

        // Get list view
        ListView danceList = (ListView) findViewById(R.id.dance_list);
    }
}

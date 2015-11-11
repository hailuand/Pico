package com.example.fall15.eecs441.pico441;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ChachaTypes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chacha_types);
        // Set up list of Chacha variations
        final ListView danceOptions = (ListView) findViewById(R.id.chacha_types);
        String[] chachaTypes = new String[] {"Basic", "New York", "Underarm Turn"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, chachaTypes);
        danceOptions.setAdapter(adapter);
        danceOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Below is debugging purposes only
                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) danceOptions.getItemAtPosition(position);

                // Show Alert
                /*
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_SHORT)
                        .show();
                        */
                // Go to dance pages
                if (itemValue == "Basic") {
                    Intent intent = new Intent(ChachaTypes.this, DanceChacha.class);
                    startActivity(intent);
                }
            }
        });
    }


}

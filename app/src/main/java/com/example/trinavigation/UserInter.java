package com.example.trinavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class UserInter extends AppCompatActivity {

    public TextView map,navigation,settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_inter);

        map = findViewById(R.id.map);
        navigation = findViewById(R.id.navigation);
        settings = findViewById(R.id.settings);

        //setting on click listener for map TextView
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mInten = new Intent(getApplicationContext(),Map.class);
                startActivity(mInten);
            }
        });


        //setting on click listener for navigation TextView

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nInten = new Intent(getApplicationContext(),Navigation.class);
                startActivity(nInten);
            }
        });
        //setting on click listener for settings Textview

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sInten = new Intent(getApplicationContext(),Settings.class);
                startActivity(sInten);
            }
        });
    }
}

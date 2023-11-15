package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Map;

public class HomePageActivity extends AppCompatActivity {
    Button maps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        maps = findViewById(R.id.btnMap);
        Intent map = new Intent(this,MapsActivity.class);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(map);
            }
        });
    }
}
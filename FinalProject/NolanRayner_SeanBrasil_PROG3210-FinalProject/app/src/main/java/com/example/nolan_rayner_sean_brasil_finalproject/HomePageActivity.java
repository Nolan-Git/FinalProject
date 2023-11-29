package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

public class HomePageActivity extends AppCompatActivity {
    Button maps, viewBirds, about, shop;
    TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        maps = findViewById(R.id.btnMap);
        viewBirds = findViewById(R.id.btnSearch);
        about = findViewById(R.id.btnAbout);
        shop = findViewById(R.id.btnShop);
        user = findViewById(R.id.tbUsername);
        SharedPreferences userpref = getSharedPreferences("info",MODE_PRIVATE);
        String username = userpref.getString("UserName","");
        Boolean isAdmin = userpref.getBoolean("isAdmin",false);
       if(isAdmin){
        user.append(username+" ISADMIN = "+isAdmin);
        }
        else{
            user.append(username+" ISADMIN = "+isAdmin);
        }
        //goes tot about view
        Intent aboutView = new Intent(this,AboutActivity.class);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(aboutView);
            }
        });
        //goes to shop view
        Intent shopView = new Intent(this,ShopActivity.class);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(shopView);
            }
        });

//goes ot map view
        Intent map = new Intent(this,MapsActivity.class);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(map);
            }
        });
        //goes to bird list view
        Intent birdSearch = new Intent(this,BirdSearchActivity.class);
        viewBirds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                birdSearch.putExtra("searchQuery","");
                birdSearch.putExtra("search",false);
                startActivity(birdSearch);
            }
        });

    }
}

package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class BirdSearchActivity extends AppCompatActivity {
    Button addBird;
    private ArrayList<BirdModel> birdModalArrayList;
    private DBHandler dbHandler;
    private BirdListAdapter birdLVAdapter;
    private RecyclerView birdLV;
    TextView txtsearch;
    String searchQuery;
    Boolean search = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_search);
        addBird = findViewById(R.id.btnAddBird);

        Intent birdAdd = new Intent(this,addBirdActivity.class);
        SharedPreferences userpref = getSharedPreferences("info",MODE_PRIVATE);
        Boolean isAdmin = userpref.getBoolean("isAdmin",false);

// initializing our all variables.
        birdModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(BirdSearchActivity.this);

// getting our course array
// list from db handler class.

            birdModalArrayList = dbHandler.readCourses();


// on below line passing our array list to our adapter class.
        birdLVAdapter = new BirdListAdapter(birdModalArrayList, BirdSearchActivity.this);
        birdLV = findViewById(R.id.BirdList);

        if(isAdmin){
            birdLVAdapter.setIsAdmin(true);
            addBird.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(birdAdd);
                }
            });
        }
        else {
            addBird.setVisibility(View.INVISIBLE);
            birdLVAdapter.setIsAdmin(false);
        }



// setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BirdSearchActivity.this, RecyclerView.VERTICAL, false);
        birdLV.setLayoutManager(linearLayoutManager);

// setting our adapter to recycler view.
        birdLV.setAdapter(birdLVAdapter);



    }


}
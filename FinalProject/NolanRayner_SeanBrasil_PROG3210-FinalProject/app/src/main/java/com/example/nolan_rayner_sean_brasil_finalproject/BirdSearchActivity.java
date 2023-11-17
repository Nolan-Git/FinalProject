package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class BirdSearchActivity extends AppCompatActivity {
    Button addBird;
    private ArrayList<BirdModel> birdModalArrayList;

    private DBHandler dbHandler;

    private BirdListAdapter birdLVAdapter;

    private RecyclerView birdLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_search);
        addBird = findViewById(R.id.btnAddBird);
        Intent birdAdd = new Intent(this,addBirdActivity.class);
        addBird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(birdAdd);
            }
        });

// initializing our all variables.
        birdModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(BirdSearchActivity.this);

// getting our course array
// list from db handler class.
        birdModalArrayList = dbHandler.readCourses();
// on below line passing our array list to our adapter class.
        birdLVAdapter = new BirdListAdapter(birdModalArrayList, BirdSearchActivity.this);
        birdLV = findViewById(R.id.BirdList);

// setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BirdSearchActivity.this, RecyclerView.VERTICAL, false);
        birdLV.setLayoutManager(linearLayoutManager);

// setting our adapter to recycler view.
        birdLV.setAdapter(birdLVAdapter);

    }


}
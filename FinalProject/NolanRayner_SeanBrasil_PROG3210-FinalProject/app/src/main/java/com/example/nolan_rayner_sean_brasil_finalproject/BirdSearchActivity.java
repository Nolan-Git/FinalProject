package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class BirdSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_search);

        ArrayList birdlist = getListData();
        final ListView lv = (ListView) findViewById(R.id.BirdList);

        lv.setAdapter(new BirdListAdapter(this,birdlist));
    }
    private ArrayList getListData() {
        ArrayList<BirdModel> results = new ArrayList<>();



        return results;
    }

}
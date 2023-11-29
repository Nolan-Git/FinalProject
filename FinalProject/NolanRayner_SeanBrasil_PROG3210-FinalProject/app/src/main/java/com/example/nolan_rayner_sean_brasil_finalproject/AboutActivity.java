package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Intent;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
//sends user to outside links
    public void btnBirdCanada_click(View view){
        goToUrl ( "https://www.birdscanada.org/");
    }

    public void btnNatGeo_click(View view){
        goToUrl ( "https://www.nationalgeographic.com/animals/birds");
    }

    public void btnAAB_click(View view){
        goToUrl ( "https://www.allaboutbirds.org/news/");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}

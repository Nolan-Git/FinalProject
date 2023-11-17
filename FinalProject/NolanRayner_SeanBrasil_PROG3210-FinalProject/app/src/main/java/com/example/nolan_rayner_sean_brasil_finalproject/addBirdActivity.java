package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addBirdActivity extends AppCompatActivity {
    private EditText birdNameEdt, birdStasusEdt, birdLocationEdt, birdDescriptionEdt;
    private Button addBirdBtn, readBirdBtn;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bird);
        // initializing all our variables.
        birdNameEdt = findViewById(R.id.idEdtBirdName);
        birdStasusEdt = findViewById(R.id.idEdtBirdStatus);
        birdLocationEdt = findViewById(R.id.idEdtBirdLocation);
        birdDescriptionEdt = findViewById(R.id.idEdtBirdDescription);
        addBirdBtn = findViewById(R.id.idBtnAddBird);
        readBirdBtn = findViewById(R.id.idBtnReadBird);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(addBirdActivity.this);

        // below line is to add on click listener for our add course button.
        addBirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String birdName = birdNameEdt.getText().toString();
                String birdstatus = birdStasusEdt.getText().toString();
                String birdLocation = birdLocationEdt.getText().toString();
                String birdDescription = birdDescriptionEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (birdName.isEmpty() && birdstatus.isEmpty() && birdLocation.isEmpty() && birdDescription.isEmpty()) {
                    Toast.makeText(addBirdActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewBird(birdName, birdLocation, birdDescription, birdstatus);

                // after adding the data we are displaying a toast message.
                Toast.makeText(addBirdActivity.this, "Bird has been added.", Toast.LENGTH_SHORT).show();
                birdNameEdt.setText("");
                birdLocationEdt.setText("");
                birdStasusEdt.setText("");
                birdDescriptionEdt.setText("");
            }
        });

        readBirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(addBirdActivity.this, BirdSearchActivity.class);
                startActivity(i);
            }
        });
}
}
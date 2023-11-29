package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UpdateBirdActivity extends AppCompatActivity {
    // variables for our edit text, button, strings and dbhandler class.
    private EditText birdNameEdt, birdStatusEdt, birdLocationEdt,
            BirdDescriptionEdt;
    private Button updateBirdBtn, deleteBirdBtn;
    private Spinner dropdown;
    private DBHandler dbHandler;
    String birdName, birdDesc, birdLocation, birdStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_bird);
// initializing all our variables.
        birdNameEdt = findViewById(R.id.idUpdateBirdName);
        birdStatusEdt = findViewById(R.id.idUPDBirdStatus);
        //birdLocationEdt = findViewById(R.id.idUpdBirdLocation);
        BirdDescriptionEdt = findViewById(R.id.idUPDBirdDescription);
        updateBirdBtn = findViewById(R.id.idBtnUpdateBird);
        deleteBirdBtn = findViewById(R.id.idBtnDeleteBird);

        String[] items =getResources().getStringArray(R.array.Locations);
        dropdown = findViewById(R.id.spinnerEdtBirdLocation1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        
        




// on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateBirdActivity.this);
// on below lines we are getting data which
// we passed in our adapter class.
        birdName = getIntent().getStringExtra("name");
        birdDesc = getIntent().getStringExtra("description");
        birdLocation = getIntent().getStringExtra("location");
        birdStatus = getIntent().getStringExtra("status");
// setting data to edit text
// of our update activity.
        birdNameEdt.setText(birdName);
        BirdDescriptionEdt.setText(birdDesc);
        birdStatusEdt.setText(birdStatus);
        int place = 0;
        for (String item : items) {
            if (item.equals(birdLocation)){
                dropdown.setSelection(place);
            }
            place++;
        }
        
        
        
        
        
        //birdLocationEdt.setText(courseDuration);
// adding on click listener to our update course button.
        updateBirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// inside this method we are calling an update course
// method and passing all our edit text values.
                dbHandler.updateCourse(birdName,
                        birdNameEdt.getText().toString(), BirdDescriptionEdt.getText().toString(),
                        birdStatusEdt.getText().toString(), dropdown.getSelectedItem().toString());
// displaying a toast message that our course has been updated.
                Toast.makeText(UpdateBirdActivity.this, "Bird Updated..",
                        Toast.LENGTH_SHORT).show();
// launching our main activity.
                Intent i = new Intent(UpdateBirdActivity.this,
                        BirdSearchActivity.class);
                startActivity(i);
            }
        });
        // adding on click listener for delete button to delete our course.
        deleteBirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// calling a method to delete our course.
                dbHandler.deleteCourse(birdName);
                Toast.makeText(UpdateBirdActivity.this, "Deleted the Bird",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateBirdActivity.this, BirdSearchActivity.class);
                startActivity(i);
            }
        });
    }
}

package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    EditText name, dob, aadhar_number, city, state, pincode, phone_number;
    Button submit;
    DBHelper MyDB;
    SharedPreferences userPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        name = (EditText) findViewById(R.id.name);
        dob = (EditText) findViewById(R.id.dob);
        aadhar_number = (EditText) findViewById(R.id.aadharNumber);
        city = (EditText) findViewById(R.id.city);
        state = (EditText) findViewById(R.id.state);
        pincode = (EditText) findViewById(R.id.pincode);
        phone_number = (EditText) findViewById(R.id.phonenumber);

        submit = (Button) findViewById(R.id.submit);

        MyDB = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namee = name.getText().toString();
                String dobb = dob.getText().toString();
                String aadhar_numberr = aadhar_number.getText().toString();
                String cityy = city.getText().toString();
                String statee = state.getText().toString();
                String pincodee = pincode.getText().toString();
                String phone_numberr = phone_number.getText().toString();

                if(aadhar_numberr.equals("") || namee.equals("") || dobb.equals("") || cityy.equals("") || statee.equals("") || pincodee.equals("") || phone_numberr.equals(""))
                {
                    Toast.makeText(RegisterPage.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Boolean result = MyDB.checkaadhar(aadhar_numberr);
                    if(result == false)
                    {
                        Boolean res = MyDB.insertData(namee, dobb, aadhar_numberr, cityy, statee, pincodee, phone_numberr);
                        if(res==true)
                        {
                            Toast.makeText(RegisterPage.this,"Registration Successful!", Toast.LENGTH_SHORT).show();
                            //SharedPreferences.Editor prefEditor = userPreferences.edit();
                            //String Username = MyDB.getName(aadhar_numberr);
                            //prefEditor.putString("UserName",Username);
                            //Boolean isAdmin = MyDB.isAdmin(aadhar_numberr);
                            //prefEditor.putBoolean("isAdmin",isAdmin);


                            Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(RegisterPage.this,"Registration Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterPage.this, "User already exists.\n Please Login", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }
}
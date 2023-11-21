package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    Button signIn;
    EditText aadhar_number;
    DBHelper MyDB;
    SharedPreferences userPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        aadhar_number = (EditText) findViewById(R.id.aadhar);

        MyDB = new DBHelper(this);

        signIn = (Button) findViewById(R.id.submit);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String aadhar_numberr = aadhar_number.getText().toString();

                if(aadhar_numberr.equals(""))
                {
                    Toast.makeText(LoginPage.this, "Enter Aadhar number", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean result = MyDB.checkaadhar(aadhar_numberr);
                    if(result == false)
                    {
                        Toast.makeText(LoginPage.this, "User does not exists.\n Kindly Register", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), RegisterPage.class);
                        startActivity(intent);
                    }
                    else{
                        //SharedPreferences.Editor prefEditor = userPreferences.edit();
                        //String Username = MyDB.getName(aadhar_numberr);
                        //prefEditor.putString("UserName",Username);
                        //Boolean isAdmin = MyDB.isAdmin(aadhar_numberr);
                       // prefEditor.putBoolean("isAdmin",isAdmin);

                        Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                        startActivity(intent);
                    }

                }

            }
        });

    }

}
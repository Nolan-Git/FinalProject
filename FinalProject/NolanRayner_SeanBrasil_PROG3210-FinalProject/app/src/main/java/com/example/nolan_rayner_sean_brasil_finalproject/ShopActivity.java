package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity {
    TextView textDisplay;
    CheckBox heron, bluejay, swan, cardinal;
    String Customer, finalDisplay, errorCheckString,printChosen;
    EditText textCustomerName, textCustomerEmail, textCustomerPhone, textCustomerCredit, textCustomerAddy;
    int heronCost, bluejayCost, cardinalCost, swanCost, totalCost;
//shop activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        textCustomerEmail = findViewById(R.id.editTextTextEmail);
        textCustomerPhone = findViewById(R.id.editTextNumber);
        textCustomerCredit = findViewById(R.id.editTextCreditCard);
        textCustomerAddy = findViewById(R.id.editTextTextName);

        textDisplay = findViewById(R.id.textViewResults);
        heron = (CheckBox)findViewById(R.id.checkBoxHeron);
        bluejay = (CheckBox)findViewById(R.id.checkBoxBlueJay);
        swan = (CheckBox)findViewById(R.id.checkBoxSwam);
        cardinal = (CheckBox)findViewById(R.id.checkBoxCardinal);

    }

    public void btnSubmit_click (View view){
        boolean errors = false, sponsorcheck=false;
        heronCost = 0;
        bluejayCost = 0;
        swanCost = 0;
        cardinalCost = 0;
        printChosen="";
        textDisplay.setText("");
        if(heron.isChecked()){
            sponsorcheck = true;
            heronCost = 200;
            printChosen+="Heron Print $200, ";
        }
        if(bluejay.isChecked()){
            sponsorcheck = true;
            bluejayCost = 150;
            printChosen+="Bluejay Print $150, ";
        }
        if(swan.isChecked()){
            sponsorcheck = true;
            swanCost = 220;
            printChosen+="Swan Print $220, ";
        }
        if(cardinal.isChecked()){
            sponsorcheck = true;
            cardinalCost = 250;
            printChosen+="Cardinal Print $250, ";
        }

        if(!sponsorcheck){
            Toast.makeText(this, "You must select at least one sponsor", Toast.LENGTH_SHORT).show();
        }

        String addy = textCustomerAddy.getText().toString().trim();
        if (addy==""){
            Toast.makeText(this, "No entered address", Toast.LENGTH_SHORT).show();
            errors=true;
        }

        String email = textCustomerEmail.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (!email.matches(emailPattern))
        {
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();
            errors=true;
        }

        String phone_number = textCustomerPhone.getText().toString().trim();
        if (phone_number.length()!=10){
            Toast.makeText(this, "Incorrect phone number. Enter 10 digits", Toast.LENGTH_SHORT).show();
            errors=true;
        }

        String card_number2 = textCustomerCredit.getText().toString().trim();
        String cardPattern = "^4[0-9]{12}(?:[0-9]{3})?$";
        if (!card_number2.matches(cardPattern))
        {
            Toast.makeText(this, "Invalid credit card number must be valid visa regex", Toast.LENGTH_SHORT).show();
            errors=true;
        }

        if (!errors) {
            totalCost = cardinalCost + swanCost + bluejayCost + heronCost;
            Toast.makeText(this, "Order successfully sent!", Toast.LENGTH_SHORT).show();
            textDisplay.setText("Total Order Cost is $" + String.valueOf(totalCost) + "\n" +"Print's Chosen: " + String.valueOf(printChosen) + "\n" + "Customer Address: "+ String.valueOf(addy) + "\n" + "Customer Email: "+ String.valueOf(email) + "\n" + "Customer Phone: "+ String.valueOf(phone_number));
        }

    }
}

package com.example.dws;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

public class Authentication extends AppCompatActivity {
    private Spinner spinner;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        spinner=findViewById(R.id.spinnerCountries);
        spinner.setAdapter(new ArrayAdapter<String >(this,android.R.layout.simple_spinner_dropdown_item,Country_Data.country_Names));

        editText=findViewById(R.id.editTextPhone);
        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code=Country_Data.country_Area_Codes[spinner.getSelectedItemPosition()];
                        String number=editText.getText().toString().trim();
                if (number.isEmpty() || number.length()<10){
                    editText.setError(" Valid Number Is Required");
                    editText.requestFocus();
                    return;
                }

                String phonne_number= "+" + code + number;
                Intent intent=new Intent(Authentication.this, Verify_phone_Activity.class);
                intent.putExtra("phone_number",phonne_number);
                startActivity(intent);
            };
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(FirebaseAuth.getInstance().getCurrentUser()!= null){
            Intent intent= new Intent(this,Home.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);/*clear eveything from the stack by closing other activity*/
            startActivity(intent);
        }
    }
}

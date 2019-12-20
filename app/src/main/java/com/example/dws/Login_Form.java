package com.example.dws;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Form extends AppCompatActivity {
EditText password,contact_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        getSupportActionBar().setTitle("Login_Form");
        password = (EditText) findViewById(R.id.pass1);
        contact_no = (EditText) findViewById(R.id.Contact);
        final String password_string = password.getText().toString().trim();
        final String contact_no_string = contact_no.getText().toString().trim();

        Button Login = (Button) findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),password_string,Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(),contact_no_string,Toast.LENGTH_SHORT).show();
                if (password_string.contains("")) {
                    password.setError("Enter password first");
                }
                if (contact_no_string=="") {
                    contact_no.setError("Enter Your Phone Number");
                }
               if(password_string!=""&&contact_no_string!="") {
                    startActivity(new Intent(getApplicationContext(), Home.class));//HOME e jabe class name
                }
            }

        });
    }

    public void btn_Signup_Formm(View view) {
        startActivity(new Intent(getApplicationContext(),Signup_Form.class));
    }
}


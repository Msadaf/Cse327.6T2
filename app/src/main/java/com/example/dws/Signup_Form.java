package com.example.dws;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

/*@Author Sadia-mim
Version @1.0
Since 17.12.2019

 */
public class Signup_Form extends AppCompatActivity {
EditText full_name,Contact,password,email,Birthdate;
RadioGroup gender;
RadioButton male,female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
       full_name=(EditText) findViewById(R.id.Full_Name);
       Contact=(EditText)findViewById(R.id.Contact);
       password=(EditText)findViewById(R.id.Pass0);
       email=(EditText)findViewById(R.id.email);
       Birthdate=(EditText)findViewById(R.id.Birthdate);
       gender=(RadioGroup)findViewById(R.id.genderradiogroup);
       male=(RadioButton)findViewById(R.id.male);
       female=(RadioButton)findViewById(R.id.female);
       Button Submit=(Button)findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener()
        /*
        @author Sadia-mim
        @version 1.0
        @Since 17.12.2019
        @deprecated click submit button go to home class ,alternative go to login class
        * */

        {
            @Override
            public void onClick(View v) {
                // Write a message to the database
               /* FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

               // myRef.setValue("Hello, World!");
                myRef.child("User").setValue("NAfisa Alam");*/
               startActivity(new Intent(Signup_Form.this,Authentication.class));

            }
        });


    }
}

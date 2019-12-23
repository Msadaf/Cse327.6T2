package com.example.dws;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

/*@Author Sadia-mim
Version @1.0
Since 17.12.2019

 */
public class Signup_Form extends AppCompatActivity {
EditText full_name,Contact,password,email,Birthdate;
String full_name_string,Contact_string,password_string,email_string,Birthdate_string,gender_string;
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






       gender.clearCheck();
       gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @SuppressLint("ResourceType")
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               RadioButton rb=(RadioButton)group.findViewById(checkedId);
               if(null!=rb&& checkedId> (-1)){
                   gender_string=rb.getText().toString().trim();
               }
           }
       });
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
                full_name_string=full_name.getText().toString().trim();
                try {
                    Contact_string=Contact.getText().toString().trim();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }finally {
                    Contact_string="01788348747";
                }
               try {
                   password_string = password.getText().toString().trim();
               }catch (Exception e){
                   Toast.makeText(getApplicationContext(),"password"+e.getMessage(),Toast.LENGTH_LONG).show();
               }

                email_string=email.getText().toString().trim();
                Birthdate_string=Birthdate.getText().toString().trim();

              try {
                  Databse databse = new Databse(full_name_string, Contact_string, email_string, password_string, Birthdate_string, gender_string);
                  databse.CreateDatabase();
              }catch (Exception e){
                  Toast.makeText(getApplicationContext(),"database"+e.getMessage(),Toast.LENGTH_LONG).show();
              }
              Intent intent=new Intent(Signup_Form.this,Authentication.class);
              intent.putExtra("Phone_num",Contact_string);
              startActivity(intent);

            }
        });


    }
}

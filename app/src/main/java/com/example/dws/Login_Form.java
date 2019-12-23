package com.example.dws;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login_Form extends AppCompatActivity {
    DatabaseReference database_login;
    EditText password, contact_no;
    String contact_no_string;
    int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        getSupportActionBar().setTitle("Login_Form");
        password = (EditText) findViewById(R.id.pass1);
        contact_no = (EditText) findViewById(R.id.Contact);
        final String password_string = password.getText().toString().trim();
        contact_no_string = contact_no.getText().toString().trim();
        database_login= FirebaseDatabase.getInstance().getReference("User/Userlist").child(contact_no_string);
        Button Login = (Button) findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(),password_string,Toast.LENGTH_SHORT).show();
                // Toast.makeText(getApplicationContext(),contact_no_string,Toast.LENGTH_SHORT).show();
                if (password_string.equals("")) {
                    password.setError("Enter password first");
                    flag = 0;
                }
                if (contact_no_string.equals("")) {
                    contact_no.setError("Enter Your Phone Number");
                    flag = 0;
                }

                if (flag == 1) {
                    //String phonenumber="+"+contact_no_string;
                    // startActivity(new Intent(getApplicationContext(), Authentication.class));
                    database_login.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(contact_no_string==dataSnapshot.child("Phone Num").getValue().toString()){
                                if(password_string==dataSnapshot.child("Password").getValue().toString()){
                                    Toast.makeText(getApplicationContext(),"Log in Successful",Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(Login_Form.this,Authentication.class);
                                    intent.putExtra("Phone_num",contact_no_string);
                                    startActivity(intent);
                                }
                                else{
                                    password.setError("Password is incorrect");
                                }
                            }
                            else {
                                contact_no.setError("Phone number is incorrect");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
            }

        });
    }

    public void btn_Signup_Formm(View view) {
        startActivity(new Intent(getApplicationContext(), Signup_Form.class));
    }
    public void Offer (View view){
        startActivity(new Intent(getApplicationContext(),Offer.class));
    }
}


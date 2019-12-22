package com.example.dws;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Offer extends AppCompatActivity {
    DatabaseReference database_Offer,database_Offer1;
    TextView T0,T1,T2  ;
    String value,value2,value3;
    Button Next;

    /*@author sadia-mim
    @version 1.5
    @param
    @since 22.12.2019
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        T0 = (TextView) findViewById(R.id.T0);
        T1=(TextView)findViewById(R.id.T1);
        T2=(TextView)findViewById(R.id.T2);
        Next = (Button) findViewById((R.id.Next));
        database_Offer = FirebaseDatabase.getInstance().getReference().child("OFFER").child("HOP IN");
        database_Offer1=FirebaseDatabase.getInstance().getReference().child("OFFER").child("DBBL");


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database_Offer.addValueEventListener(new ValueEventListener() {

                    /*@author sadia-mim
                    @version 1.5
                    @param object , return null value
                    @since 22.12.2019
                    @see https://www.youtube.com/watch?v=LpWhAz3e1sI&t=35s
                     */
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        value = dataSnapshot.child("100% Discount").getValue().toString();
                        value2=dataSnapshot.child("20% Discount").getValue().toString();
                        try {


                        }catch (Exception e){
                            e.getMessage();
                            Toast.makeText( getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                        }


                        T0.setText(value);
                        T1.setText(value2);



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
              });
                database_Offer1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        value3 = dataSnapshot.child("50% Discount").getValue().toString();
                        T2.setText(value3);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }


        //DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        //DatabaseReference myRef = database.getReference("Order/DBBL");

        // Read from the database
        //database.addValueEventListener(new ValueEventListener() {


    }


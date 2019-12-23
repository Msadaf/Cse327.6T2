package com.example.digital_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/*
@author nafisa alam
@version 1.0
@since since-19/dec/2019
@deprecated represents home

 */
public class MainActivity extends AppCompatActivity {
String Phonenum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.add_btn)).setOnClickListener(new View.OnClickListener() {


    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this,ScanningQrCode.class));



    }
});
        ((Button)findViewById(R.id.view_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewCardAndCredentials.class));
            }
        });


        ((Button)findViewById(R.id.offer_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Offer.class));
            }
        });

    }
}

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




/**
 * Displays Home Links Add,View,Offer function
 * @author nafisa alam
 * @since since-17/dec/2019
 *@version 2.0
 *
 */
@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
String Phonenum;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/**
 *@deprecated Button Function
 */
        ((Button)findViewById(R.id.add_btn)).setOnClickListener(new View.OnClickListener() {

            /**
             * @deprecated to add Cards and credential , scanning the QR Code
             * @param view
             */
    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this,ScanningQrCode.class));



    }
});
        /**
         *
         */
        ((Button)findViewById(R.id.view_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * @deprecated to view Cards and credential , Viewing the QR Code
             * @param view
             */
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewCardAndCredentials.class));
            }
        });


        ((Button)findViewById(R.id.offer_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * @deprecated to view Offer , Viewing the QR Code
             * @param view
             */
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Offer.class));
            }
        });
        ((Button)findViewById(R.id.search_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * @deprecated to view Cards and credential , Viewing the QR Code
             * @param view
             */
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Search.class));
            }
        });


        ((Button)findViewById(R.id.history_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * @deprecated to view Offer , Viewing the QR Code
             * @param view
             */
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,History.class));
            }
        });

/**
 * @deprecated Button funtion Ends
 */
    }
}

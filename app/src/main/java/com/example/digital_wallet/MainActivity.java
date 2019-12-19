package com.example.digital_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

/*
@author nafisa alam
@version 1.0
@since since-19/dec/2019
@deprecated represents home

 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add button on click function
        /*
@author nafisa alam

@since since-19/dec/2019
@deprecated represents button function


 */
        (findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //class change
           startActivity(new Intent(MainActivity.this,AddCardsAndCredentials.class));
            }
        });


    }
}

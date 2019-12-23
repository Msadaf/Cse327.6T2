package com.example.digital_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Confirm Window
 * @author nafisa alam
 * @since 21/12/2019
 */

public class ConfirmAdded extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_added);

/**
 * Confirm Addition of Cards and Credentials
 */
        startActivity(new Intent( ConfirmAdded.this,ViewCardAndCredentials.class));


    }
}

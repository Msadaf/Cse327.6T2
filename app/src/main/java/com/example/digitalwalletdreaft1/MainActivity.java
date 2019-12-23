package com.example.digitalwalletdreaft1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bttn, bttn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttn = findViewById(R.id.button4);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                move_to_history();

            }
        });
        bttn = findViewById(R.id.button3);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                move_to_search();

            }
        });
    }

        private void move_to_history(){

            Intent in = new Intent(MainActivity.this, History.class);
            startActivity(in);
        }

    private void move_to_search(){

        Intent in2 = new Intent(MainActivity.this, Search.class);
        startActivity(in2);
    }

}

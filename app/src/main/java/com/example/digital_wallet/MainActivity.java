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
String Phonenum="01788856789";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {


    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this,AddCardsAndCredentials.class));
//entry_to_database database=new entry_to_database();
       // DatabaseReference refref = ref.child(Phonenum);

      //  Map<String, entry_to_database> users = new HashMap<>();
       // users.put(Phonenum, new entry_to_database("111","my card","Cards","1234","1/2/2012","2/4/2020","jkdjf"));
       // users.put("gracehop", new entry_to_database("December 9, 1906", "Grace Hopper"));

      // ref.child(Phonenum).setValue(users.put(Phonenum, new entry_to_database("111","my card","Cards","1234","1/2/2012","2/4/2020","jkdjf")));
        //usersRef.child("gracehop").setValueAsync(new User("December 9, 1906", "Grace Hopper"));
//refref.setValue(users);
//ref.child(Phonenum).setValue( "111" );

//ref.child(Phonenum).child("Tittle").setValue("cnc:djj");
        //entry_to_database database2=new entry_to_database("111","my card","Cards","1234","1/2/2012","2/4/2020","jkdjf");
        //database2.database();


    }
});

    }
}

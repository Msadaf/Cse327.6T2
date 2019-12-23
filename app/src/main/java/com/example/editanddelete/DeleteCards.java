package com.example.editanddelete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.editanddelete.Confirm;
import com.example.editanddelete.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Delets cards and credentials from Database
 * @author Ananna Talukder
 *@version 1.2
 *@since 22/12/2019

 */

public class DeleteCards extends AppCompatActivity {




    String Phone_num;
    DatabaseReference databaseTicket;

    /**
     * @exception NullPointerException
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_cards);



try{
    Phone_num=getIntent().getStringExtra("Phone_num").toString();
}catch (Exception e){

}finally {



    Phone_num="01788348747";
}
                FirebaseDatabase database=FirebaseDatabase.getInstance();

               databaseTicket= database.getReference("CardsAndCredentials/Catagory/Cards");

                databaseTicket.child(Phone_num).removeValue();
                startActivity(new Intent(DeleteCards.this, Confirm.class));

            }



}

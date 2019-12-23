package com.example.editanddelete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


       /* This "DeleteCards is extended from another another class which is auto built in"
        * @param Unused.
        * @return Nothing.
        * @exception IOException On input error.
        * @see IOException
        */

public class DeleteCards extends AppCompatActivity {


    /* @Author Ananna Talukder
     *@version 1.3
     *@since 22/12/2019
     *@param  num is the string parameter
     *@return nothing
     */

    String num="474";
    DatabaseReference databaseTicket;
  //  EditText Tittle,Catagory,Cardnum,Desc,Issue_date,Expire_date;
  //  String tittle,catagory,cardnum,issuedate,expiredate,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_cards);


         /*8       tittle=Tittle.getText().toString().trim();
                cardnum=Cardnum.getText().toString().trim();
                description=Desc.getText().toString().trim();
                issuedate=Issue_date.getText().toString().trim();
                expiredate=Expire_date.getText().toString().trim();*/


                FirebaseDatabase database=FirebaseDatabase.getInstance();

               databaseTicket= database.getReference("CardsAndCredentials/Catagory/Tickets");

                databaseTicket.child(num).removeValue();
                startActivity(new Intent(DeleteCards.this,Confirm.class));

            }



}

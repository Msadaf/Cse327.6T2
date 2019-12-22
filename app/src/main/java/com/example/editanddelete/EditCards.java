package com.example.editanddelete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditCards extends AppCompatActivity {
    String Phonenum="01788348747";
    DatabaseReference databaseTicket;
EditText Tittle,Catagory,Cardnum,Desc,Issue_date,Expire_date;
    String tittle,catagory,cardnum,issuedate,expiredate,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_cards);
        tittle=getIntent().getStringExtra("tittle");
       // catagory=getIntent().getStringExtra("catagory");
        cardnum=getIntent().getStringExtra("cardnum");
        issuedate=getIntent().getStringExtra("issuedate");
        expiredate=getIntent().getStringExtra("expiredate");
        description=getIntent().getStringExtra("description");



        Tittle=(EditText)findViewById(R.id.tittle);
      //  Catagory=(EditText)findViewById(R.id.catagory);
        Cardnum=(EditText)findViewById(R.id.cardandcrednum);
        Desc=(EditText)findViewById(R.id.description);
        Issue_date=(EditText)findViewById(R.id.issuedate);
        Expire_date=(EditText)findViewById(R.id.expiredate);




        Tittle.setText(tittle);
       // Catagory.setText(catagory);
        Cardnum.setText(cardnum);
        Desc.setText(description);
        Issue_date.setText(issuedate);
        Expire_date.setText(expiredate);


        ((Button)findViewById(R.id.button_submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tittle=Tittle.getText().toString().trim();
                cardnum=Cardnum.getText().toString().trim();
                description=Desc.getText().toString().trim();
                issuedate=Issue_date.getText().toString().trim();
                expiredate=Expire_date.getText().toString().trim();


               FirebaseDatabase database=FirebaseDatabase.getInstance();

                DatabaseReference databaseReference= database.getReference("CardsAndCredentials/Catagory/Tickets");

                databaseReference.child(Phonenum).child("Tittle").setValue(tittle);
                databaseReference.child(Phonenum).child("Cards and Credential Number").setValue(cardnum);
                databaseReference.child(Phonenum).child("Desc").setValue(description);
                databaseReference.child(Phonenum).child("Issue Date").setValue(issuedate);
                databaseReference.child(Phonenum).child("Expire Date").setValue(expiredate);

            }
        });





    }
}

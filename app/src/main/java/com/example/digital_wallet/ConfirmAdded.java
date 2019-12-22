package com.example.digital_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmAdded extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_added);
       /* String PhoneNum,Tittle,Catagory,CardNCredNum,IssueDate,ExpireDate,Desc,Qr_Code;
        PhoneNum=getIntent().getStringExtra("PhoneNum");
        Tittle=getIntent().getStringExtra("Tittle");
        Catagory= getIntent().getStringExtra("Catagory");
        CardNCredNum=getIntent().getStringExtra("CardNCredNum");

        IssueDate=getIntent().getStringExtra("IssueDate");
        ExpireDate=getIntent().getStringExtra("ExpireDate");

        Desc=getIntent().getStringExtra("Desc");
        Qr_Code=getIntent().getStringExtra("Qr_code");
        Toast.makeText(getApplicationContext(),"p"+PhoneNum+CardNCredNum+"\nc"+Catagory+"\nc"+Tittle+"\nc"+IssueDate
                +"\nc"+ExpireDate+"\nc"+Desc+"\nc"+Qr_Code+"\nc",Toast.LENGTH_LONG).show();
        entry_to_database database=new entry_to_database(PhoneNum,Tittle,Catagory,CardNCredNum,
                IssueDate,ExpireDate,Desc,Qr_Code);
        database.CreateDatabase();*/

       startActivity(new Intent( ConfirmAdded.this,ViewCardAndCredentials.class));


    }
}

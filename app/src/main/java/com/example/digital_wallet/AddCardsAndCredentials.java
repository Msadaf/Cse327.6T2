package com.example.digital_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/*
@author nafisa alam

@since since-19/dec/2019
@deprecated  class where user will add cards and credentials

 */
public class AddCardsAndCredentials extends AppCompatActivity  {
    //variables declaration
    EditText tittle_name,cards_num,issue_date,expire_date,descrption_details;
    String tittle_name_string,cards_num_string,issue_date_string,expire_date_string,descrption_details_string;
    Spinner catagory;
    Spinner choice;
    String catagory_item;
    String choice_item;
    int flag=1,cameraopen=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cards_and_credentials);

/*
@author nafisa alam

@since since-19/dec/2019
@deprecated represents variable value getting from the ui

 */
          tittle_name=(EditText)findViewById(R.id.tittle);
          cards_num=(EditText)findViewById(R.id.cardandcrednum);
          issue_date=(EditText)findViewById(R.id.issuedate);
          expire_date=(EditText)findViewById(R.id.expiredate);
          descrption_details=(EditText)findViewById(R.id.description);
          catagory=(Spinner)findViewById(R.id.catagory);
          choice=(Spinner)findViewById(R.id.choice);
          Button button_submit=(Button)findViewById(R.id.button_submit);

/*
@author nafisa alam

@since since-19/dec/2019
@deprecated covetrt edittext to string

 */




          /*
@author nafisa alam

@since since-19/dec/2019
@deprecated represents spinner button value

 */
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.catagory, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        catagory.setAdapter(adapter);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.choice, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        choice.setAdapter(adapter1);


         //spinner button value getting end

        //button submit function start
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tittle_name_string=tittle_name.getText().toString().trim();
                cards_num_string=cards_num.getText().toString().trim();
                issue_date_string=issue_date.getText().toString().trim();
                expire_date_string=expire_date.getText().toString().trim();
                choice_item=choice.getSelectedItem().toString();
                catagory_item=catagory.getSelectedItem().toString();
                descrption_details_string=descrption_details.getText().toString().trim();
                 //error text for edittext
                Toast.makeText(getApplicationContext(),"tittle:"+tittle_name_string,Toast.LENGTH_SHORT).show();
                if (tittle_name_string.equals("")) {

                    tittle_name.setError("Please Enter Meter Reading");
                    flag=0;
                     }
                if (cards_num_string.equals("")) {
                    cards_num.setError("Please Enter Meter Reading");
                    flag=0;
                }
                if (issue_date_string.equals("")) {
                    issue_date.setError("Please Enter Meter Reading");
                    flag=0;
                }
                if (expire_date_string.equals("")) {
                    expire_date.setError("Please Enter Meter Reading");
                    flag=0;
                }
                else {
                    flag=1;
                }

                switch (catagory_item){

                    case "Cards":
                        Toast.makeText(getApplicationContext(),"cards:",Toast.LENGTH_SHORT).show();
                        flag=1;
                        break;
                    case "Tickets":
                        flag=1;
                        break;
                    case "Coupons":
                        flag=1;

                        break;
                    case "Choose one":
                        TextView errorText = (TextView)catagory.getSelectedView();
                        errorText.setError("");
                        errorText.setTextColor(Color.RED);
                        errorText.setText(" You must Select One Catagory");
                        flag=0;

                        break;
                        default:
                            break;


                }
                switch (choice_item){
                    case "Open Camera":
                        flag=1;
                        cameraopen=1;

                        break;
                    case "Upload":
                        flag=1;
                        break;

                    case "Choose one":
                        TextView errorText = (TextView)choice.getSelectedView();
                        errorText.setError("");
                        errorText.setTextColor(Color.RED);
                        errorText.setText(" You must Select One Option");
                        flag=0;

                        break;


                }

               /* if(flag==1){
                    startActivity(new Intent(AddCardsAndCredentials.this,MainActivity.class));

                }*/
               if(flag==1&&cameraopen==1){
                   startActivity(new Intent(AddCardsAndCredentials.this,ScanningQrCode.class));
               }


            }
        });

        //button submit function ends




    }



//main function ends

    /*
@author nafisa alam

@since since-19/dec/2019
@deprecated method of Spinner regarding catagory and choice
@param position of catagory
@return none

 */

}

package com.example.digital_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
@author nafisa alam

@since since-19/dec/2019
@deprecated  class where user will add cards and credentials

 */
public class AddCardsAndCredentials extends AppCompatActivity  {
    //variables declaration
    EditText tittle_name,cards_num,issue_date,expire_date,descrption_details;
    String phone_num="01788348747";
    String tittle_name_string,cards_num_string,issue_date_string,expire_date_string,descrption_details_string,catagory_item_string;
    Spinner catagory;
    Spinner choice;
    String catagory_item;
    String choice_item;
    int flag=1;
    final Calendar issuedatecalender = Calendar.getInstance();
    final Calendar expiredatecalender = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    DatePickerDialog.OnDateSetListener mdate;
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

          Button button_submit=(Button)findViewById(R.id.button_submit);
         final String qr_code=getIntent().getStringExtra("Qr_Code");

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                issuedatecalender.set(Calendar.YEAR, year);
                issuedatecalender.set(Calendar.MONTH, monthOfYear);
               issuedatecalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(2);
            }

            private void updateLabel(int s) {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                issue_date.setText(sdf.format(issuedatecalender.getTime()));


            }

        };
        mdate = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                expiredatecalender.set(Calendar.YEAR, year);
                expiredatecalender.set(Calendar.MONTH, monthOfYear);
                expiredatecalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel("");
            }

            private void updateLabel(String s) {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                expire_date.setText(sdf.format(expiredatecalender.getTime()));

            }

        };


        issue_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddCardsAndCredentials.this, date, issuedatecalender
                        .get(Calendar.YEAR), issuedatecalender.get(Calendar.MONTH),
                        issuedatecalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        expire_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddCardsAndCredentials.this,mdate , issuedatecalender
                        .get(Calendar.YEAR), issuedatecalender.get(Calendar.MONTH),
                        issuedatecalender.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
         


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




        //button submit function start
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                tittle_name_string=tittle_name.getText().toString().trim();
                cards_num_string=cards_num.getText().toString().trim();
                issue_date_string=issue_date.getText().toString().trim();
                expire_date_string=expire_date.getText().toString().trim();

                catagory_item=catagory.getSelectedItem().toString();
                descrption_details_string=descrption_details.getText().toString().trim();
                 //error text for edittext
               // Toast.makeText(getApplicationContext(),"issuedate:"+issue_date_string+expire_date_string,Toast.LENGTH_SHORT).show();
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
                        //Toast.makeText(getApplicationContext(),"cards:",Toast.LENGTH_SHORT).show();
                        catagory_item_string="Cards";
                        flag++;
                        break;
                    case "Tickets":
                        catagory_item_string="Tickets";
                        flag++;
                        break;
                    case "Coupons":
                        catagory_item_string="Coupons";
                        flag++;

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
                entry_to_database database_add=new entry_to_database(phone_num,tittle_name_string,catagory_item_string,
                        cards_num_string,issue_date_string,expire_date_string,
                       descrption_details_string
                        ,qr_code);
                database_add.CreateDatabase();

               if(flag==2){
                   Intent intent=new Intent(AddCardsAndCredentials.this,ConfirmAdded.class);
                   /*intent.putExtra("Tittle",tittle_name_string);
                   intent.putExtra("Catagory",catagory_item_string);
                   intent.putExtra("Card_and_crednum",cards_num_string);
                   intent.putExtra("Issue_date",issue_date_string);
                   intent.putExtra("Expire_date",expire_date_string);
                   intent.putExtra("Description",descrption_details_string);
                   intent.putExtra("Phone",phone_num);
                   startActivity(intent);*/
               }
               else{
                   Toast.makeText( AddCardsAndCredentials.this,"Select all field",Toast.LENGTH_SHORT).show();
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

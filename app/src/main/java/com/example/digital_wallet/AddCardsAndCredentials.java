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

/**
 * Adds Cards and Credentials
 * @author nafisa alam
 * @version
 * @since since-17/dec/2019
 *  @docRoot MainActivity.class
 * @param
 */

@SuppressWarnings("deprecation")
public class AddCardsAndCredentials extends AppCompatActivity  {
    /**
     *  Variable declaration For EditText
     */
    EditText tittle_name,cards_num,issue_date,expire_date,descrption_details;
    /**
     *  String Variable Declaration
     */
    String phone_num;
    String tittle_name_string,cards_num_string,issue_date_string,expire_date_string,descrption_details_string,catagory_item_string;
    Spinner catagory;
    String catagory_item;

    int flag=1;
    /**
     * Variable declaration For Calender View
     */
    final Calendar issuedatecalender = Calendar.getInstance();
    final Calendar expiredatecalender = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    DatePickerDialog.OnDateSetListener mdate;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cards_and_credentials);

/**
 *  EditText passing data From Layout
 */
          tittle_name=(EditText)findViewById(R.id.tittle);
          cards_num=(EditText)findViewById(R.id.cardandcrednum);
          issue_date=(EditText)findViewById(R.id.issuedate);
          expire_date=(EditText)findViewById(R.id.expiredate);
          descrption_details=(EditText)findViewById(R.id.description);
          catagory=(Spinner)findViewById(R.id.catagory);
/**
 *  Button Submit For Next
 * @exception throws null pointer Exception
 */
          Button button_submit=(Button)findViewById(R.id.button_submit);
         final String qr_code=getIntent().getStringExtra("Qr_Code");
         try {
             phone_num = getIntent().getStringExtra("Phone_num").toString();
         }catch (Exception e){

         }finally {
             phone_num="01788348747";
         }
        date = new DatePickerDialog.OnDateSetListener() {

            /**
             * View Calender
             * @param view
             * @param year
             * @param monthOfYear
             * @param dayOfMonth
             */
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                issuedatecalender.set(Calendar.YEAR, year);
                issuedatecalender.set(Calendar.MONTH, monthOfYear);
               issuedatecalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(2);
            }

            /**
             * Set Date to ISsue date edit text
             * @param s
             */
            private void updateLabel(int s) {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                issue_date.setText(sdf.format(issuedatecalender.getTime()));


            }

        };
        mdate = new DatePickerDialog.OnDateSetListener() {

            /**
             *
             * @param view
             * @param year
             * @param monthOfYear
             * @param dayOfMonth
             */
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                expiredatecalender.set(Calendar.YEAR, year);
                expiredatecalender.set(Calendar.MONTH, monthOfYear);
                expiredatecalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel("");
            }

            /**
             * Expire Date Edittext Set date
             * @param s
             */
            private void updateLabel(String s) {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                expire_date.setText(sdf.format(expiredatecalender.getTime()));

            }

        };


        issue_date.setOnClickListener(new View.OnClickListener() {

            /**
             * Get issuedate as String
             * @param v
             */
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddCardsAndCredentials.this, date, issuedatecalender
                        .get(Calendar.YEAR), issuedatecalender.get(Calendar.MONTH),
                        issuedatecalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        expire_date.setOnClickListener(new View.OnClickListener() {
            /**
             * Get expiredate as String
             * @param v
             */
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddCardsAndCredentials.this,mdate , issuedatecalender
                        .get(Calendar.YEAR), issuedatecalender.get(Calendar.MONTH),
                        issuedatecalender.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


/**
 * Drop Down Button for Catagory
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
            /**
             * getting String From Edittext,Passing values to
             * @exception NullPointerException
             * @param view
             */
            @Override
            public void onClick(View view) {


                tittle_name_string=tittle_name.getText().toString().trim();
                cards_num_string=cards_num.getText().toString().trim();
                issue_date_string=issue_date.getText().toString().trim();
                expire_date_string=expire_date.getText().toString().trim();

                catagory_item=catagory.getSelectedItem().toString();
                descrption_details_string=descrption_details.getText().toString().trim();

               // Toast.makeText(getApplicationContext(),"issuedate:"+issue_date_string+expire_date_string,Toast.LENGTH_SHORT).show();
                /**
                 * Setting Error text for not filling
                 */
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
                /**
                 * Object creating
                 */
                entry_to_database database_add=new entry_to_database(phone_num,tittle_name_string,catagory_item_string,
                        cards_num_string,issue_date_string,expire_date_string,
                       descrption_details_string
                        ,qr_code);
                database_add.CreateDatabase();

               if(flag==2){
                   Intent intent=new Intent(AddCardsAndCredentials.this,ConfirmAdded.class);

               }
               else{
                   Toast.makeText( AddCardsAndCredentials.this,"Select all field",Toast.LENGTH_SHORT).show();
               }




            }

        });






    }





}

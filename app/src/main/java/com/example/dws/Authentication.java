package com.example.dws;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
//import com.google.firebase.auth.FirebaseAuth;

public class Authentication extends AppCompatActivity {
    Button _btn_LogIn, _btn_VerOTP;
    EditText _txt_Name, _txt_Phone, _txt_VerOTP;
    int randomNumber;

    @Override
    protected void  onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
/*@author sadia-mim
@version 1.4
@since 22.12.2019
@param
@see https://www.youtube.com/watch?v=TB9B3fMvTNU
 */

        _txt_Name=(EditText)findViewById(R.id.txtName);
        _txt_Phone=(EditText)findViewById(R.id.txtPhone);
        _txt_VerOTP=(EditText)findViewById(R.id.txtVerOTP);
        _btn_LogIn=(Button)findViewById(R.id.btnLogin);
        _btn_VerOTP=(Button)findViewById(R.id.btnVerOTP);
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy .Builder().permitAll().build();/*strict thread*/
        StrictMode.setThreadPolicy(policy);
        _btn_VerOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Construct data
                    String apiKey = "apikey=" + "KXt+sLIvdXk-aUlTrwpDVfTRjqM0QS6bG962eencJZ";
                    Random random= new Random();
                    randomNumber=random.nextInt(999999);
                    String message = "&message=" + "Dear User"+_txt_Name.getText().toString()+ "Your OTP IS "+randomNumber;
                    String sender = "&sender=" + "TSN";
                    String numbers = "&numbers=" +_txt_Phone.getText().toString();
    /*@Author sadia-mim
    @Version 1.4
    @Since 22.12.2019
    @param
    @see http://api.txtlocal.com/docs/sendsms
     */

                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        stringBuffer.append(line);
                    }
                    rd.close();
                    Toast.makeText(getApplicationContext(), "OTP SEND SUCCESSFULLY", Toast.LENGTH_LONG).show();

                    //return stringBuffer.toString();
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "ERROR SMS "+e, Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "ERROR "+e, Toast.LENGTH_LONG).show();
                    //System.out.println("Error SMS "+e);
                    //return "Error "+e;
                }
            }


        });

        /*@Author sadia-mim
        @Version 1.4
        @Since 22.12.2019
        @param return void
        /*
         */
        _btn_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(randomNumber==Integer.valueOf(_txt_VerOTP.getText().toString())){
                    Toast.makeText(getApplicationContext(), " LOGIN Successfull", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Authentication.this,MainActivity.class));

                }else{
                    startActivity(new Intent(Authentication.this,MainActivity.class));
                    Toast.makeText(getApplicationContext(), "WRONG OTP", Toast.LENGTH_LONG).show();
                }

            }
        });



    }}





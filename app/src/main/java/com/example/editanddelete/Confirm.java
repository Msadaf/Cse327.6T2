package com.example.editanddelete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Confirm extends AppCompatActivity {
    /* This" Confirm" is extended from another another class which is auto built in"
     * @param  Unused.
     * @return Nothing.
     * @exception IOException On input error.
     * @see IOException
     */
    /* @Author Ananna Talukder
     *@version 1.4
     *@since 22/12/2019

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        TextView textView=(TextView)findViewById(R.id.textView);
    }
}

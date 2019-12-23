package com.example.editanddelete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


/**Java
 * @author Ananna Talukder
 *@version 1.4
 *@since 22/12/2019
 */

public class Confirm extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        TextView textView=(TextView)findViewById(R.id.textView);
    }
}

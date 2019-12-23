package com.example.digital_wallet;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Views Cards and Credentials,Links Edit and Delete Function
 * @author nafisa alam
 * @version 2.0
 * @since 22/12/2019
 *
 */
public class ViewCardAndCredentials extends AppCompatActivity {

    /**
     * variable declaration
     */
    DatabaseReference database_cards;
    Button click;
    String PhoneNum;
    String Tittle,Catagory,Cardnum,Issue_date,Expire_date,Desc,Qr_code;
    TextView tv,tittle,catagory,cardnum,isssuedate,expiredate,desc;
    ImageView qr_code;
    LinearLayout layout_id;
    QRGEncoder qrgEncoder;
    Bitmap bitmap;
    @Override
    /**
     * @exception NullPointerException
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_card_and_credentials);
        try {
            PhoneNum = getIntent().getStringExtra("Phone_num").toString();
        }catch (Exception e){

        }finally {
            PhoneNum="01788348747";
        }
        /**
         * passing data from edittext
         */
        click=(Button)findViewById(R.id.click);
       layout_id =(LinearLayout)findViewById(R.id.linear_layout_id);
        database_cards=FirebaseDatabase.getInstance().getReference().child("CardsAndCredentials").
                child("Catagory").child("Cards").child(PhoneNum);
        ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tv=new TextView(this);
        tv.setLayoutParams(lparams);

     tittle=(TextView)findViewById(R.id.tittle);
     catagory=(TextView)findViewById(R.id.catagory);
     cardnum=(TextView)findViewById(R.id.cardandcrednum);
     isssuedate=(TextView)findViewById(R.id.issuedate);
     expiredate=(TextView)findViewById(R.id.expiredate);
     desc=(TextView)findViewById(R.id.description);
     qr_code=(ImageView)findViewById(R.id.qrcode);
        final Button button_edit=(Button)findViewById(R.id.edit_btn);
        final Button button_delete=(Button)findViewById(R.id.button_submit);
      click.setOnClickListener(new View.OnClickListener() {
          /**
           *
           * @param view
           */
          @Override
          public void onClick(View view) {
              database_cards.addValueEventListener(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                      Tittle=dataSnapshot.child("Tittle").getValue().toString();
                      Catagory=dataSnapshot.child("Catagory").getValue().toString();
                      Cardnum=dataSnapshot.child("Cards and Credential Number").getValue().toString();
                     Issue_date=dataSnapshot.child("Issue Date").getValue().toString();
                      Expire_date=dataSnapshot.child("Expire Date").getValue().toString();
                     Desc=dataSnapshot.child("Desc").getValue().toString();
                      Qr_code=dataSnapshot.child("Qr Code").getValue().toString();

                       tittle.setText("Tittle: "+Tittle);
                       catagory.setText("Catagory: "+Catagory);
                       cardnum.setText("Credentials "+Cardnum);
                       isssuedate.setText("Issue DAte: "+Issue_date);
                       expiredate.setText("Expire Date: "+Expire_date);
                       desc.setText("Description: "+Desc);
/**
 * Qr Code Generating from Text
 */
                         if(Qr_code.length()>0){
                             WindowManager manager=(WindowManager)getSystemService(WINDOW_SERVICE);
                             Display display=manager.getDefaultDisplay();
                             Point point=new Point();
                             display.getSize(point);
                             int width=point.x;
                             int height=point.y;
                             int smallerdimension=width<height?width:height;
                             smallerdimension=smallerdimension*3/4;

                             qrgEncoder=new QRGEncoder(Qr_code,null, QRGContents.Type.TEXT,smallerdimension);
                             try{
                                 bitmap=qrgEncoder.encodeAsBitmap();
                              qr_code.setImageBitmap(bitmap);
                             }catch (Exception e){
                                 e.getMessage();
                             }
                         }
                         else{

                         }
                      /**
                       * Edit Cards and Credentials
                       */
                      button_edit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent=new Intent(ViewCardAndCredentials.this,EditCards.class);
                                intent.putExtra("tittle",Tittle);
                                intent.putExtra("phone_num",PhoneNum);
                                intent.putExtra("cardnum",Cardnum);
                                intent.putExtra("issuedate",Issue_date);
                                intent.putExtra("expiredate",Expire_date);
                                intent.putExtra("description",Desc);
                                startActivity(intent);

                            }
                        });
                      /**
                       * Delete Cards and Credentials
                       */
                      button_delete.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View view) {
                              startActivity(new Intent(ViewCardAndCredentials.this,DeleteCards.class));

                          }
                      });


                  }

                  @Override
                  public void onCancelled(@NonNull DatabaseError databaseError) {

                  }
              });

          }
      });


    }
    public String Catagory(String s) {
        if (s.equals("Cards"))
            s= "Cards";

        if (s.equals("Tickets"))
            s= "Cards";

        if (s.equals("Coupons"))
            s= "Coupons";

        return s;
    }


}

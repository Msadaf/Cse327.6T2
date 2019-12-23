package com.example.digital_wallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class ScanningQrCode extends AppCompatActivity {
    Button done_button;
    SurfaceView cameraView;
    TextView txtResult;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    final int RequestCameraPermissionID=1;
    public String qr_code_value_string;
    String PhoneNum,Tittle,Catagory,CardNCredNum,IssueDate,ExpireDate,Desc,Qr;



    /*@Author Nafisa-Alam
            @Version
            @Since
            @See
            @param
             */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning_qr_code);
        //Bind XML view

        cameraView=findViewById(R.id.cameraPreview);
        txtResult=findViewById(R.id.showResult);
        done_button=findViewById(R.id.done_button);
        PhoneNum=getIntent().getStringExtra("Phone");
        Tittle=getIntent().getStringExtra("Tittle");
        Catagory= getIntent().getStringExtra("Catagory");
        CardNCredNum=getIntent().getStringExtra("Card_and_crednum");

        IssueDate=getIntent().getStringExtra("Issue_date");
        ExpireDate=getIntent().getStringExtra("Expire_date");

        Desc=getIntent().getStringExtra("Description");



        barcodeDetector=new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.QR_CODE)
                .build();

        cameraSource=new CameraSource.Builder(this, barcodeDetector).setAutoFocusEnabled(true)
                .setRequestedPreviewSize(640,480).build();
        //Now add event to show camera preview

        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {

            /*@Author Nafisa-Alam
            @Version
            @Since
            @See
            @param
             */
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                //Check permissions here first

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(ScanningQrCode.this,new String[]{Manifest.permission.CAMERA},RequestCameraPermissionID);
                    return;
                }
                try {
                    //If permission Granted then start Camera
                    cameraSource.start(cameraView.getHolder());
                }
                catch (Exception e)
                {
                    Toast.makeText(ScanningQrCode.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();

            }
        });
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }
            /*@Author Nafisa-Alam
                        @Version
                        @Since
                        @See
                        @param
                         */
            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {

                final SparseArray<Barcode> sparseArray=detections.getDetectedItems();
                if (sparseArray.size() != 0)
                {
                    txtResult.post(new Runnable() {
                        @Override
                        public void run() {
                            //Here i am creating vibration so when we scan any barcode its vibrate
                            if(sparseArray.valueAt(0).displayValue!=null){
                                txtResult.setText(sparseArray.valueAt(0).displayValue);
                                done_button.setVisibility(View.VISIBLE);
                                qr_code_value_string=sparseArray.valueAt(0).displayValue;
                                done_button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //Toast.makeText(getApplicationContext(),PhoneNum,Toast.LENGTH_SHORT).show();
                                       //Toast.makeText(getApplicationContext(),"p"+PhoneNum+" t"+Tittle+" c"+Catagory+" c"+
                                               //CardNCredNum+" i"+IssueDate+" e"+ExpireDate+" d"+
                                               //Desc+" q"+qr_code_value_string,Toast.LENGTH_SHORT).show();

                                       // Toast.makeText(getApplicationContext(),database_add.getCatagory() ,Toast.LENGTH_SHORT).show();
                                        //entry_to_database d=new entry_to_database("474","jfj","Tickets","73437","7/8/27","5/5/5","fuffu",qr_code_value_string);
                                       // d.CreateDatabase();
                                        Intent intent =new Intent(ScanningQrCode.this,AddCardsAndCredentials.class);
                                        /*intent.putExtra("PhoneNum",PhoneNum);
                                        intent.putExtra("Tittle",Tittle);
                                        intent.putExtra("Catagory",Catagory);
                                        intent.putExtra("CardNCredNum",CardNCredNum);
                                        intent.putExtra("IssueDate",IssueDate);
                                        intent.putExtra("ExpireDate",ExpireDate);
                                        intent.putExtra("Desc",Desc);*/
                                        intent.putExtra("Qr_Code",qr_code_value_string);
                                        startActivity(intent);



                                    }
                                });
                            }




                            //Toast.makeText(getApplicationContext(),sparseArray.valueAt(0).displayValue,Toast.LENGTH_LONG).show();
                            //Thats All
                        }


                    });
                }

            }
        });

    }

/*@Author Nafisa-Alam
            @Version
            @Since
            @See
            @param
             */

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case RequestCameraPermissionID:
                if (grantResults[0]== PackageManager.PERMISSION_GRANTED)
                {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                    {
                        return;
                    }
                    try {
                        //If permission Granted then start Camera
                        cameraSource.start(cameraView.getHolder());
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }
}

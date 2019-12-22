package com.example.dws;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

/*import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;*/

import java.util.concurrent.TimeUnit;

public class Verify_phone_Activity extends AppCompatActivity {


    private String verification_Id;
   // private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
;        setContentView(R.layout.activity_verify_phone_);

/*@author sadia-mim
@Version 1.1
@since 19.12.2019
@Parameter phonenumber passing; check validation succeed ,then display the progress bar
 */

     //   mAuth = FirebaseAuth.getInstance();
        progressBar= findViewById(R.id.progressbar);
        editText= findViewById(R.id.editTextCode);
        String phonenumber = String.valueOf(getIntent().getStringArrayExtra("phonne_number"));

        senderVericationCode(phonenumber);
        findViewById(R.id.buttonLogIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code= editText.getText().toString().trim();

                if (code.isEmpty() || code.length()<6){
                    editText.setError("Enter Code......");
                    editText.requestFocus();
                    return;

                }

                verifyCode(code);

            }
        });
    }
    /*@Author sadia-mim
    @version 1.1
    @since 20.12.2019
    @method for verify the cde takes 2 parametr*/
    private void verifyCode(String code){
      //  PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verification_Id,code);
        //signInWithCredential(credential);

    }

   /* private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(Verify_phone_Activity.this, new OnCompleteListener<AuthResult>() {
                    private Task<AuthResult> task;

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        this.task = task;
                        if (task.isSuccessful()) {
                            Intent intent= new Intent(Verify_phone_Activity.this,Home.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);/*clear eveything from the stack by closing other activity*/
                       /*     startActivity(intent);
                        } else {
                            Toast.makeText(Verify_phone_Activity.this, task.getException().getMessage(), Toast.LENGTH_LONG);
                        }
                    }

                })


    ;}*/

    private void senderVericationCode(String number){
        progressBar.setVisibility(View.VISIBLE);
       // PhoneAuthProvider.getInstance().verifyPhoneNumber(
             //   number,
             //   60,
               // TimeUnit.SECONDS,
               // TaskExecutors.MAIN_THREAD,
               // mCallback
       // )

    }
   // private PhoneAuthProvider.OnVerificationStateChangedCallbacks
         //   mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

       // @Override
       /*public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verification_Id=s;
        }/*metho when code is sent*/

        //@Override
       /* public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code =phoneAuthCredential.getSmsCode(); /*method veri is complet*/
         /*   if (code!=null){
                editText.setText(code); /*set code to the edit text*/

               // verifyCode(code);
          /*  }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(Verify_phone_Activity.this,e.getMessage(),Toast.LENGTH_LONG).show();

        }*/
   // };
}

package com.example.habibapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    private ImageView ImView;
    private EditText etEmail,etPassword;
    private Button btSignIn,btSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

      ImView=(findViewById(R.id.ImView));
       etEmail=(findViewById(R.id.etEmail));
       etPassword=(findViewById(R.id.etPassword));
       btSignIn=(findViewById(R.id.btSignIn));
       btSignUp=(findViewById(R.id.btSignUp));

       btSignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(getApplicationContext(),SignUp.class);
               startActivity(i);
           }
       });


        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dataHandler();
            }
        });



    }
    private void dataHandler()
    {
        String email=etEmail.getText().toString();
        String passw=etPassword.getText().toString();
        boolean isok=true;

        if (email.length()<4)
        {
            etEmail.setError("Email length error");
            isok=false;
        }
       if (email.indexOf("@")<0 || email.indexOf(".")<0)
       {
           etEmail.setError("email wrong format");
           isok=false;
       }
 //  if (isValidEmailAddress(email)==false)
  // {
      // etEmail.setError("Invalid Email");
      // isok=false;
  // }
   if (passw.length()<8)
   {
       etPassword.setError("min length 8");
       isok=false;
   }
   if (isok)
   {
    signIn(email,passw);
   }

    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    private void signIn(String email, String passw)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful())
               {
                   //todo go to ,main screen(all task activity)
                   Intent i=new Intent(getApplication(),TempAllTaskActivity.class);
                   startActivity(i);

               }
               else
               {
                   etEmail.setError("email or password ia wrong");
               }
            }
        });
    }
}


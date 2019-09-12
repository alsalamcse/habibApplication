package com.example.habibapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignIn extends AppCompatActivity {
    private ImageView ImView;
    private EditText etEmail,etPassword;
    private Button btSignIn,btSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

      ImView=(ImageView)(findViewById(R.id.ImView));
       etEmail=(EditText)(findViewById(R.id.etEmail));
       etPassword=(EditText)(findViewById(R.id.etPassword));
       btSignIn=(Button)(findViewById(R.id.btSignIn));
       btSignUp=(Button)(findViewById(R.id.btSignUp));

    }
}

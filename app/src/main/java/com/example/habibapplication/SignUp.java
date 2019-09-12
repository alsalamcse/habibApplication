package com.example.habibapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        etFirstName=(findViewById(R.id.etFirstName));
        etLastName=(findViewById(R.id.etLastName));
        etPhone=(findViewById(R.id.etPhone));
        etEmail=(findViewById(R.id.etEmail));
        etPassword=(findViewById(R.id.etPassword));

    }
}

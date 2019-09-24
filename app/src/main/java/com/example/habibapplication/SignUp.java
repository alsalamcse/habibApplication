package com.example.habibapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etReeter;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        etFirstName=(findViewById(R.id.etFirstName));
        etLastName=(findViewById(R.id.etLastName));
        etPhone=(findViewById(R.id.etPhone));
        etEmail=(findViewById(R.id.etEmail));
        etPassword=(findViewById(R.id.etPassword));
        etReeter=(findViewById(R.id.etReeterPassword));
        save=(findViewById(R.id.btSave));

    }

    private void datahandler()
    {
        String email=etEmail.getText().toString();
        String passw=etPassword.getText().toString();
        boolean isok=true;
    }
}

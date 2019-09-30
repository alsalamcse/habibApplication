package com.example.habibapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity
{
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword1, etPassword2;
    private EditText etReeter;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        etFirstName = (findViewById(R.id.etFirstName));
        etLastName = (findViewById(R.id.etLastName));
        etPhone = (findViewById(R.id.etPhone));
        etEmail = (findViewById(R.id.etEmail));
        etPassword1 = (findViewById(R.id.etPassword));
        etPassword2 = (findViewById(R.id.etPassword));
        etReeter = (findViewById(R.id.etReeterPassword));
        save = (findViewById(R.id.btSave));

        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dataHandler();
            }

            private void dataHandler()
            {

                boolean isok = true;
                String email = etEmail.getText().toString();
                String passw1 = etPassword1.getText().toString();
                String passw2 = etPassword2.getText().toString();
                String fname = etFirstName.getText().toString();
                String lname = etLastName.getText().toString();
                String phone = etPhone.getText().toString();
                if (email.length() < 4 || email.indexOf('@') < 0 || email.indexOf('.') < 0) {
                    etEmail.setError("Wrong Email");
                    isok = false;
                }
                if (passw1.length() < 8 || passw2.equals(passw2) == false)
                {
                    etPassword1.setError("Have to be at least 8 char and the same password");
                    etPassword2.setError("Have to be at least 8 char and the same password");
                    isok = false;
                }
                if (fname.length() == 0)
                {
                    etFirstName.setError("enter name");
                    isok = false;
                }
                if (isok)
                {
                    createAcount(email,passw1,fname,lname,phone );

                }
            }
        });
    }



    private void createAcount(String email, String passw1, String fname, String lname, String phone)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,passw1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(SignUp.this, "Sign up Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    etEmail.setError("Sign n up field");
                }
            }
        });
    }
}
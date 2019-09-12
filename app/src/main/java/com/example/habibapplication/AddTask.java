package com.example.habibapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddTask extends AppCompatActivity {
    private EditText etTitle,etSubject;
    private SeekBar skbrImportant;
    private Button btnSave;
    private TextView tvPrioroty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task2);

        etTitle=(EditText)(findViewById(R.id.etTitle));
        etSubject=(EditText)(findViewById(R.id.etSubject));
        skbrImportant=(SeekBar)(findViewById(R.id.skbrImportant));
        btnSave=(Button)(findViewById(R.id.btnSave));
        tvPrioroty=(TextView)(findViewById(R.id.tvPriority));
    }
}

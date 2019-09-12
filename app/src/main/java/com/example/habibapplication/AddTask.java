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

        etTitle=(findViewById(R.id.etTitle));
        etSubject=(findViewById(R.id.etSubject));
        skbrImportant=(findViewById(R.id.skbrImportant));
        btnSave=(findViewById(R.id.btnSave));
        tvPrioroty=(findViewById(R.id.tvPriority));
    }
}

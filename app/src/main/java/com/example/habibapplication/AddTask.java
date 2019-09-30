package com.example.habibapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dataHandler();

            }
        });
    }

    private void dataHandler()
    {
        String title= etTitle.getText().toString();
        String subject=etSubject.getText().toString();
        int seecbar=skbrImportant.getProgress();
        boolean isok=true;

        if (title.length()<1)
        {
            etTitle.setError("title lengh error");
            isok=false;
        }
        if (subject.length()<1)
        {
            etSubject.setError("subject lengh error");
        }
        if (isok)
        {
            createTask(title,subject,seecbar);
        }


    }
    private void createTask(String title,String subject,int seecbar){

    }
}

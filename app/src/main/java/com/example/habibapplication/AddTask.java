package com.example.habibapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.habibapplication.data.MyTask;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
            MyTask t=new MyTask();
            t.setTitle(title);
            creatMyTask(t);
            createTask(title,subject,seecbar);
        }


    }

    private void creatMyTask(MyTask t)
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference();
        String key = reference.child("tasks").push().getKey();
        reference.child("tasks").child(key).setValue(t).addOnCompleteListener(AddTask.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(AddTask.this, "add successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddTask.this, "add failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });

    }

    private void createTask(String title,String subject,int seecbar)
    {

    }
}

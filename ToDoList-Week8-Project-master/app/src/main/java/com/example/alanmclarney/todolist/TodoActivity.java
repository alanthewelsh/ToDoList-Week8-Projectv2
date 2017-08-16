package com.example.alanmclarney.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_task);

        Intent intent = getIntent();
        Task task = (Task) intent.getSerializableExtra("task");

        TextView title = (TextView) findViewById(R.id.taskTitle);
        TextView description = (TextView) findViewById(R.id.taskDescrip);

        title.setText(task.getName());
        description.setText(task.getDescription());
    }
}

package com.example.alanmclarney.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TodoList todoList = new TodoList();
        ArrayList<Task> tasks = todoList.returnList();



        ToDoListAdapter toDoListAdapter = new ToDoListAdapter(this, tasks);
        ListView listView = (ListView) findViewById(R.id.lvItems);
        listView.setAdapter(toDoListAdapter);

    }
    
    public void onListItemClick(View listItem){
        Task task = (Task) listItem.getTag();
        Log.d("This is for ",  task.getName());
        Intent intent = new Intent(this, TodoActivity.class);
        intent.putExtra("task", task);

        startActivity(intent);
    }







}
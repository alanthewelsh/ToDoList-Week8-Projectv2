package com.example.alanmclarney.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static int ADD_LIST_ITEM = 0;
    private ToDoListAdapter toDoListAdapter;
    private String myTaskList;
    private SharedPreferences sharedPref;
    private TypeToken<ArrayList<Task>> taskArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TodoList todoList = new TodoList();
        ArrayList<Task> tasks = todoList.returnList();

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        myTaskList = sharedPref.getString("MyTasks", new ArrayList<Task>().toString());

        Gson gson = new Gson();
        taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> myTasks = gson.fromJson(myTaskList, taskArrayList.getType());
        Log.d("myTasks", String.valueOf(myTasks));

        toDoListAdapter = new ToDoListAdapter(this, myTasks);
        ListView listView = (ListView) findViewById(R.id.lvItems);
        listView.setAdapter(toDoListAdapter);

    }

    private void addTask(Task task) {
        toDoListAdapter.add(task);

        Gson gson = new Gson();

        //Save new fave to SharedPref
        SharedPreferences.Editor editor = sharedPref.edit();
        Log.d("MyTasks length", String.valueOf(toDoListAdapter.getCount()));
        Log.d("MyTasks", gson.toJson(toDoListAdapter.getItems()));
        editor.putString("MyTasks", gson.toJson(toDoListAdapter.getItems(), taskArrayList.getType()));
        editor.apply();
    }

    
    public void onListItemClick(View listItem){
        Task task = (Task) listItem.getTag();
        Log.d("This is for ",  task.getName());
        Intent intent = new Intent(this, TodoActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

    public void addNewItem(View v) {
        Intent intent = new Intent(this, AddDataActivity.class);
        startActivityForResult(intent, ADD_LIST_ITEM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == this.ADD_LIST_ITEM) {
            Task task = (Task) data.getSerializableExtra("item");
            addTask(task);
        }
    }


}
package com.example.alanmclarney.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by alanmclarney on 16/08/2017.
 */

public class AddDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data);
    }

    public void onAddDataClick(View item) {
        EditText title = (EditText) findViewById(R.id.editTask);
        EditText description = (EditText) findViewById(R.id.editTaskDetails);

        Task task = new Task(title.getText().toString(), description.getText().toString(), 0);
        Intent intent = new Intent();
        intent.putExtra("item", task);
        setResult(MainActivity.ADD_LIST_ITEM, intent);
        finish();
    }


}

package com.example.alanmclarney.todolist;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by alanmclarney on 15/08/2017.
 */

class ToDoListAdapter extends ArrayAdapter<Task> {

    public ToDoListAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }

        Task currentTask = getItem(position);

//        TextView priority = (TextView) listItemView.findViewById(R.id.priority);
//        priority.setText( currentTask.getPriority().toString() );

        TextView name = listItemView.findViewById(R.id.name);
        name.setText( currentTask.getName() );

//        TextView description = (TextView) listItemView.findViewById(R.id.description);
//        description.setText( currentTask.getDescription().toString() );

        listItemView.setTag(currentTask);
        return listItemView;

    }
}

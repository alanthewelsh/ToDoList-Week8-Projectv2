package com.example.alanmclarney.todolist;

import java.util.ArrayList;

/**
 * Created by alanmclarney on 15/08/2017.
 */

public class TodoList {

    private ArrayList<Task> tasks;

    public TodoList(){
        this.tasks = new ArrayList<Task>();
    }


    public Task getTask(Task task){
       int index = this.tasks.indexOf(task);
        return this.tasks.get(index);
    }

    public void setTaskName(Task task, String newName) {
        Task oldTask = this.getTask(task);
        oldTask.setName(newName);
    }

    public int taskCount(){
        return tasks.size();
    }

    public void addTask(Task task){
        tasks.add(task);
    }


    public void removeTask(Task task){
        tasks.remove(task);
    }



}

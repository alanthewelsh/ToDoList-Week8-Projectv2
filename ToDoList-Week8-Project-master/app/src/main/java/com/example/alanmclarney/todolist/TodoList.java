package com.example.alanmclarney.todolist;

import java.util.ArrayList;

/**
 * Created by alanmclarney on 15/08/2017.
 */

public class TodoList {

    private ArrayList<Task> tasks;

    public TodoList(){
        this.tasks = new ArrayList<Task>();
        tasks.add(new Task("Shopping", "Go to the shops", 2));
        tasks.add(new Task("Work", "Go to the Work", 1));
        tasks.add(new Task("Pub", "Go to the pub", 3));

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

    public ArrayList<Task> returnList(){
        return new ArrayList<Task>(this.tasks);
    }




}

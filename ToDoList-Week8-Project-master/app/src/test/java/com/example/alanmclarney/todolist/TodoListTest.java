package com.example.alanmclarney.todolist;

import org.junit.Before;
import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by alanmclarney on 15/08/2017.
 */

public class TodoListTest {

    TodoList taskstodo;
    Task task1;
    Task task2;
    Task task3;


    @Before
    public void before() {
        taskstodo = new TodoList();
        task1 = new Task("Shopping", "Go to the shops", 2);
        task1 = new Task("Work", "Go to the Work", 1);
        task1 = new Task("Pub", "Go to the pub", 3);
        taskstodo.addTask(task1);
//        taskstodo.addTask("Go to the shops");
//        taskstodo.addTask("Go to work");
//        taskstodo.addTask("Meet friends");
    }

    @Test
    public void taskIsPresent(){
        assertEquals(task1, taskstodo.getTask(task1));
    }

    @Test
    public void taskIsChanged(){
        taskstodo.setTaskName(task1, "Clean flat");
        assertEquals("Clean flat", taskstodo.getTask(task1).getName());
    }

    @Test
    public void canAddTask(){
        taskstodo.addTask(task2);
        assertEquals(1, taskstodo.taskCount());
    }



}

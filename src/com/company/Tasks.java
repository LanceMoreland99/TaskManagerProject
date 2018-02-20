package com.company;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tasks {

    private Scanner input = new Scanner(System.in);
    public final Menu menu;
    private List<Info> TaskLibrary = new ArrayList<Info>();
    private List<Info> CompletedTasks = new ArrayList<Info>();
    private List<Info> UncompletedTasks = new ArrayList<Info>();

    public Tasks(Menu menu) {
        this.menu = menu;
    }
    protected void addTask(Info info) {
        //Code to add task goes here.
        System.out.println("What is the name of your task?");
        info.setTaskName(input.nextLine());

        System.out.println("When is your task due? MM/dd/yy");
        info.setDueDate(input.nextLine());

        System.out.println("What details would you like to keep for this task?");
        info.setDetails(input.nextLine());

        TaskLibrary.add(info);
        UncompletedTasks.add(info);
        menu.startMenu();

    }
    protected void removeTask(int taskIndex) {

        taskIndex -= taskIndex;
        System.out.println("You have removed a task from your task lists.");
        TaskLibrary.remove(taskIndex);

        menu.startMenu();

    }
    protected void showAllTasks(int taskIndex) {

    }
}

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

    protected void showAllTasks(int location) {

        System.out.println("This is all your current tasks. ");
        int index = 1;
        for (Info info : TaskLibrary) {
            System.out.println(index++ + ". " + info.getTaskName() + " due " + info.getDueDate());
        }

        if (TaskLibrary.isEmpty()) {
            System.out.println("Your task list is currently empty.");
        }
    }

    protected void deleteTasks() {

        System.out.println("This is all your current tasks. ");
        int index = 1;
        for (Info info : TaskLibrary) {
            System.out.println(index++ + ". " + info.getTaskName() + " due " + info.getDueDate());
        }

        if (TaskLibrary.isEmpty()) {
            System.out.println("Your task list is currently empty.");
        } else {
            System.out.println("You have chosen to delete a task");
            System.out.println("What task would you like to delete?");
            removeTask(input.nextInt());
        }
    }

    protected void completedTasks() {

        System.out.println("These are your completed tasks");
        int index = 1;
        for (Info info : CompletedTasks) {
            System.out.println(index++ + ". " + info.getTaskName() + " due " + info.getDueDate());
        }
    }

    protected void addTaskToCompleted(int taskIndex) {

        taskIndex -= taskIndex;
        Info info = TaskLibrary.get(taskIndex);
        UncompletedTasks.remove(taskIndex);
        CompletedTasks.add(info);
    }

    protected void showUncompletedTasks() {
        int index = 1;
        System.out.println("These are your currently uncompleted tasks.");
        for (Info info : UncompletedTasks) {
            System.out.println(index++ + ". " + info.getTaskName() + " due " + info.getDueDate());
        }
    }
}

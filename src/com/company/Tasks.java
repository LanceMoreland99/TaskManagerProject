package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Tasks {

    private Scanner input = new Scanner(System.in);
    public final Menu menu;
    private List<Info> taskLibrary = new ArrayList<Info>();
    private List<Info> completedTasks = new ArrayList<Info>();
    private List<Info> uncompletedTasks = new ArrayList<Info>();

    public Tasks(Menu menu) {
        this.menu = menu;
    }

    protected void addTask(Info info) {

        System.out.println("What is the name of your task?");
        info.setTaskName(input.nextLine());

        System.out.println("When is your task due? MM/dd/yy");
        info.setDueDate(input.nextLine());

        System.out.println("What details would you like to keep for this task?");
        info.setDetails(input.nextLine());

        taskLibrary.add(info);
        uncompletedTasks.add(info);
        menu.startMenu();

    }

    protected void removeTask(int taskIndex) {

        taskIndex -= taskIndex;
        System.out.println("You have removed a task from your task lists.");
        taskLibrary.remove(taskIndex);


        menu.startMenu();

    }

    protected void showAllTasks(int location) {

        System.out.println("This is all your current tasks. ");
        int index = 1;
        for (Info info : taskLibrary) {
            System.out.println(index++ + ". " + info.getTaskName() + " due " + info.getDueDate());
        }

        if (taskLibrary.isEmpty()) {
            System.out.println("Your task list is currently empty.");
        }
    }

    protected void deleteTasks() {

        System.out.println("This is all your current tasks. ");
        int index = 1;

        for (Info info : taskLibrary) {
            System.out.println(index++ + ". " + info.getTaskName() + " due " + info.getDueDate());
        }

        if (taskLibrary.isEmpty()) {
            System.out.println("Your task list is currently empty.");
        }
        else {
            System.out.println("You have chosen to delete a task");
            System.out.println("What task would you like to delete?");
            int userInput = input.nextInt();
            if(userInput > taskLibrary.size()){
                System.out.println("please insert a number that follows the correct numbers above.");
                deleteTasks();
            }
            else{removeTask(userInput);


            }

        }
    }

    protected void completedTasks() {

        System.out.println("These are your completed tasks");
        int index = 1;
        for (Info info : completedTasks) {
            System.out.println(index++ + ". " + info.getTaskName() + " due " + info.getDueDate() + "\n");
        }
    }

    protected void addTaskToCompleted(int taskIndex) {

        taskIndex -= taskIndex;
        Info info = taskLibrary.get(taskIndex);
        uncompletedTasks.remove(taskIndex);
        completedTasks.add(info);
    }

    protected void showUncompletedTasks() {
        int index = 1;
        System.out.println("These are your currently uncompleted tasks.\n");
        for (Info info : uncompletedTasks) {
            System.out.println(index++ + ". " + info.getTaskName() + " due " + info.getDueDate() + "\n");
        }
    }

    protected void editTaskInfo() {

        int index = 1;

        System.out.println("What task would you like to edit?\n");
        for (Info info : taskLibrary) {
            System.out.println(index++ + ". " + info.getTaskName() + " due " + info.getDueDate() + "\n");
        }
        int userInput = input.nextInt() - 1;

        if(userInput > taskLibrary.size()){
            System.out.println("please insert a number from one of the following above.");
            editTaskInfo();
        }

        else {
            Info displayTask = taskLibrary.get(userInput);

            System.out.println(displayTask.getTaskName() + " " + displayTask.getDueDate() + " " + displayTask.getDetails());

        }
        Info displayTask = taskLibrary.get(userInput);
        try {
            System.out.println("What would you like to do?\n" +
                    "1. Edit task name.\n" +
                    "2. Edit task's due date.\n" +
                    "3. Edit task details.\n" +
                    "4. Go back to task options.\n" +
                    "5. Go to the main menu.\n");
            switch (input.nextInt()) {

                case 1:
                    System.out.println("What would you like to make the name of this task?\n");
                    input.nextLine();
                    displayTask.setTaskName(input.nextLine());
                    System.out.println(displayTask.getTaskName() + " " + displayTask.getDueDate() + " " + displayTask.getDetails());
                    editTaskInfo();
                    break;
                case 2:
                    System.out.println("What is the new due date?\n");
                    input.nextLine();
                    displayTask.setDueDate(input.nextLine());
                    System.out.println(displayTask.getTaskName() + " " + displayTask.getDueDate() + " " + displayTask.getDetails());
                    editTaskInfo();
                    break;
                case 3:
                    System.out.println("What details would you like to add about this task?\n");
                    input.nextLine();
                    displayTask.setDetails(input.nextLine());
                    System.out.println(displayTask.getTaskName() + " " + displayTask.getDueDate() + " " + displayTask.getDetails());
                    editTaskInfo();
                    break;
                case 4:
                    menu.taskOptions();
                    break;
                case 5:
                    menu.startMenu();
                    break;

                default:
                    editTaskInfo();

            }

        } catch (InputMismatchException ime) {
            System.out.println("Please enter a number from the above. 1-5 \n");

        }
    }
}


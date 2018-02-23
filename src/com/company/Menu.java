package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);
    private Tasks tasks = new Tasks(this);

    public void startMenu() {

        System.out.println("What would you like to do?\n" +
                "1. Create a new task.\n" +
                "2. Delete an existing task.\n" +
                "3. View task options.\n" +
                "4. Exit.");


        try {
            switch (input.nextInt()) {

                case 1:
                    //Create new task.
                    Info info = new Info();
                    input.nextLine();
                    System.out.println("You have chosen to create a new task.");

                    //List options to create a task.
                    tasks.addTask(info);
                    break;
                case 2:
                    //Delete a task.
                    tasks.deleteTasks();
                    startMenu();
                    break;
                case 3:
                    //Go to task menu.
                    taskMenu();
                    break;
                case 4:
                    //Exit task.
                    System.out.println("Thank you for using task manager, Good bye. ");
                    System.exit(0);
            }

        } catch (InputMismatchException ime) {
            input.nextLine();
            System.out.println("Please input a correct number from above 1-4.\n");
            startMenu();
        }
    }


    public void taskMenu() {
        System.out.println("What would you like to do?\n" +
                "1. Display tasks options.\n" +
                "2. Display uncompleted task options.\n" +
                "3. Display completed tasks.\n" +
                "4. go back to the main menu.");
        try {
            switch (input.nextInt()) {
                case 1:
                    //All tasks options
                    taskOptions();
                    break;
                case 2:
                    //Uncompleted tasks options
                    uncompletedTaskMenu();
                    break;
                case 3:
                    tasks.completedTasks();
                    taskMenu();
                    break;
                case 4:
                    //go back to main menu
                    startMenu();
                    break;
            }
        } catch (InputMismatchException ime) {
            input.nextLine();
            System.out.println("Please input a correct number from above 1-4.\n");
            taskMenu();


        }
    }


    public void taskOptions() {
        System.out.println("What would you like to do?\n" +
                "1. Display all tasks\n" +
                "2. Edit task information\n" +
                "3. Go back to task menu.\n" +
                "4. go back to the main menu.");
        try {
            switch (input.nextInt()) {
                case 1:
                    //display all tasks
                    tasks.showAllTasks(1);
                    taskOptions();
                    break;
                case 2:
                    //Edit task information
                    tasks.editTaskInfo();
                    break;
                case 3:
                    //Go back to tasks
                    taskMenu();
                    break;
                case 4:
                    //go back to main menu
                    startMenu();
                    break;
            }
        } catch (InputMismatchException ime) {
            input.nextLine();
            System.out.println("Please input a correct number from above 1-4.\n");
            taskOptions();


        }
    }


    public void uncompletedTaskMenu() {
        System.out.println("What would you like to do?\n" +
                "1. Display uncompleted tasks.\n" +
                "2. Mark as completed.\n" +
                "3. Go back to task menu.\n" +
                "4. Go to the main menu.");
        try {
            switch (input.nextInt()) {
                case 1:
                    //show uncompleted tasks
                    tasks.showUncompletedTasks();
                    uncompletedTaskMenu();
                    break;
                case 2:
                    //Mark completed tasks.
                    tasks.showUncompletedTasks();
                    System.out.println("What task would you like to add to completed?");
                    tasks.addTaskToCompleted(input.nextInt());
                    uncompletedTaskMenu();
                    break;
                case 3:
                    //Go back to task menu.
                    taskMenu();
                    break;
                case 4:
                    //go back to main menu.
                    startMenu();
                    break;
            }

        } catch (InputMismatchException ime) {
            input.nextLine();
            System.out.println("Please input a correct number from above 1-4.\n");
            uncompletedTaskMenu();

        }
    }
}

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
                    input.nextLine();
                    Info info = new Info();
                    System.out.println("You have chosen to create a new task.");
                    tasks.addTask(info);
                    break;
                case 2:
                    tasks.deleteTasks();
                    startMenu();
                    break;
                case 3:
                    taskMenu();
                    break;
                case 4:
                    System.out.println("Thank you for using task manager, Good bye. ");
                    System.exit(0);
                default:
                    System.out.println("Please enter one of the following numbers between 1 and 4.");

                    startMenu();
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
                    taskOptions();
                    break;
                case 2:
                    uncompletedTaskMenu();
                    break;
                case 3:
                    tasks.completedTasks();
                    taskMenu();
                    break;
                case 4:
                    startMenu();
                    break;

                default:
                    System.out.println("Please enter one of the following numbers between 1 and 4.");

                    taskMenu();
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
                    tasks.showAllTasks(1);
                    taskOptions();
                    break;
                case 2:
                    tasks.editTaskInfo();
                    break;
                case 3:
                    taskMenu();
                    break;
                case 4:
                    startMenu();
                    break;

                default:
                    System.out.println("Please enter one of the following numbers between 1 and 4.");

                    taskOptions();
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
                    tasks.showUncompletedTasks();
                    uncompletedTaskMenu();
                    break;
                case 2:
                    tasks.showUncompletedTasks();
                    System.out.println("What task would you like to add to completed?");
                    tasks.addTaskToCompleted(input.nextInt());
                    uncompletedTaskMenu();
                    break;
                case 3:
                    taskMenu();
                    break;
                case 4:
                    startMenu();
                    break;

                default: System.out.println("Please enter a number between 1 and 4");

                uncompletedTaskMenu();

            }

        } catch (InputMismatchException ime) {
            input.nextLine();
            System.out.println("Please input a valid number from above 1-4.\n");
            uncompletedTaskMenu();

        }
    }
}



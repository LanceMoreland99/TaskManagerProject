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


        try{
            switch(input.nextInt()) {

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
                    System.out.println("You have chosen to delete a task.\n" +
                            "What task would you like to delete?");

                    Info info1 = new Info();
                    tasks.removeTask(input.nextInt());
                    break;
                case 3:
                    //View tasks.
                    System.out.println("These are your tasks. what would you like to do?\n" +
                            "1. View all tasks.\n" +
                            "2. View uncompleted tasks.\n" +
                            "3. View completed tasks.\n" +
                            "4. Go back to the previous menu.");
                    //Go to next menu.

                    break;
                case 4:
                    //Exit task.
                    System.out.println("Thank you for using task manager, Good bye. ");
                    System.exit(0);
                }

        }catch (InputMismatchException ime){
            input.nextLine();
            System.out.println("Please input a correct number from above 1-4.\n");

        }

    }
}

package ToDoList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().doAll();
    }

    Tasks tasks = new Tasks();

    void doAll() {
        Scanner scanner = new Scanner(System.in);
        String userChoice = " ";
        System.out.println("Welcome to ToDoList.");
        do {

            System.out.println("1. Add a task");
            System.out.println("2. Delete task / task was done");
            System.out.println("3. Edit task");
            System.out.println("4. Show the tasks needs to be done");
            System.out.println("5. Exit the To Do List");

            System.out.println("Enter your choice:");
            userChoice = scanner.nextLine();
            handleUserChoice(userChoice);
        } while (!userChoice.equals("5"));

    }

    private void handleUserChoice(String userChoice) {
        switch (userChoice) {
            case "1": {
                //Add a task
                Scanner scanner = new Scanner(System.in);
                System.out.println("write a task (end with blank/empty line): ");

                while (scanner.hasNextLine()) {
                    String task = scanner.nextLine();
                    if (task.isBlank()) {//why not showing isEmpty method?
                        break;
                    }
                    tasks.add(task);
                }
            }
            break;
            case "2"://Delete task / task was done")
            {
                System.out.println("Select a number which task do you want to remove (-1 to cancel deletion)?");

                String[] elements = tasks.getAsArray();
                int idx = 1;
                for (String element : elements) {
                    System.out.println(idx + ": " + element);
                    idx++;
                }


                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                if (choice < 0) {
                    break;
                }
                String result = tasks.removeTask(choice - 1);
                if ("OK".equals(result)) {
                    System.out.println("Task" + result + "has been deleted");
                } else {
                    System.err.println("Failed to remove task " + result);
                }
            }
            break;

            case "3"://Edit task - call on specific task and edit it
            {
                String[] elements = tasks.getAsArray();
                int idx = 1;
                for (String element : elements) {
                    System.out.println(idx + ": " + element);
                    idx++;
                }

                System.out.println("Which task do you want to edit (-1 to cancel modification)?");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                if (choice < 0) {
                    break;
                }
                scanner.nextLine(); // skip to end of line
                System.out.println("Current task is: " + tasks.getTask(choice - 1));
                System.out.println("Enter new task details (blank line to cancel editing)");
                String details = scanner.nextLine();
                if (details.isBlank()) {
                    break;
                }
                String result = tasks.edit(choice - 1, details);
                if ("OK".equals(result)) {
                    System.out.println("Task has been modified," +result);
                } else {
                    System.err.println("Failed to edit task");
                }
            }
            break;
            case "4"://Show the tasks needs to be done - print all stored entries in the Tasks class
                String[] elements = tasks.getAsArray();
                int idx = 1;
                for (String element : elements) {
                    System.out.println(idx + ": " + element);
                    idx++;
                }

                break;
            case "5"://Exit the To Do List
                System.out.println("ending program. Good bye.");
                break;
            default:
                System.out.println("please try again, option not implemented");
        }
    }
}


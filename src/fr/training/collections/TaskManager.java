package src.fr.training.collections;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Task Manager app - Working with ArrayList
 */
public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        System.out.println();
        System.out.println("--- Tasks Manager ---");

        addMultipleTasks(scanner, tasks, 5);
        showTasks(tasks);
        deleteTask(scanner, tasks);
        showTasks(tasks);

        scanner.close();
    }

    /**
     * Starts the process of adding a certain number of tasks to the list
     * @param scanner Allows user input to create tasks
     * @param tasks Array of tasks
     * @param nbrTasks Number of tasks to create
     */
    public static void addMultipleTasks(Scanner scanner, ArrayList<String> tasks, int nbrTasks) {
        for(int i = 0; i < nbrTasks; i++) {
            addTask(scanner, tasks);
        }
    }

    /**
     * Create a task and adds it to the list of tasks
     * @param scanner Allows user input to create tasks
     * @param tasks Array of tasks
     */
    public static void addTask(Scanner scanner, ArrayList<String> tasks) {
        String task;

        System.out.print("Add a new task: ");
        task = scanner.nextLine();

        tasks.add(task);
    }

    /**
     * Displays the list of tasks
     * @param tasks Array of tasks
     */
    public static void showTasks(ArrayList<String> tasks) {
        for(int i = 0;i < tasks.size(); i++) {
            System.out.printf("Task %s: %s%n", i + 1, tasks.get(i));
        }
    }

    /**
     * Deletes a task with the input of the user
     * @param scanner Allows user input to create tasks
     * @param tasks Array of tasks
     */
    public static void deleteTask(Scanner scanner, ArrayList<String> tasks) {
        int idTask;

        System.out.print("Delete task number: ");
        idTask = scanner.nextInt() - 1;

        if(idTask >= 0 && idTask < tasks.size()) {
            tasks.remove(idTask);
        } else {
            System.out.println("Error: wrong task number: " + idTask + 1);
        }

    }
}

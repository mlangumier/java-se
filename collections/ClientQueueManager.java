package collections;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Client Queue Manager app - Working with TreeSet
 */
public class ClientQueueManager {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        String[] clientsList = { "Mathieu", "Samuel", "Hans", "Sarah", "Mathieu", "Henry" };

        System.out.println();
        System.out.println("--- Queue Manager ---");

        generateQueue(queue, clientsList);
        displayQueue(queue);

        System.out.println();
        System.out.println("- A new client joins the queue");
        addToQueue(queue, "Divish");
        displayQueue(queue);

        System.out.println();
        System.out.println("- The first waiting client was called and leaves the queue");
        removeClientCalledFromQueue(queue);
        displayQueue(queue);

    }

    /**
     * Fills the queue with a list of clients
     * @param queue Array of clients
     */
    public static void generateQueue(LinkedList<String> queue, String[] clientsList) {
        queue.addAll(Arrays.asList(clientsList));
    }

    /**
     * Shows the clients waiting in the queue and their position
     * @param queue Array of clients
     */
    public static void displayQueue(LinkedList<String> queue) {
        for (int i = 0; i < queue.size(); i++) {
            System.out.printf("Position %s: %s%n", i + 1, queue.get(i));
        }
    }

    /**
     * Add a new client to the queue
     * @param queue Array of clients
     * @param newClient Client to add to the queue
     */
    public static void addToQueue(LinkedList<String> queue, String newClient) {
        queue.addLast(newClient);
    }

    /**
     * Remove the first client from the queue array
     * @param queue Array of clients
     */
    public static void removeClientCalledFromQueue(LinkedList<String> queue) {
        queue.removeFirst();
    }
}

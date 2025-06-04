package src.fr.training.exceptions.event_signup;

import src.fr.training.exceptions.event_signup.exceptions.EventFullException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EventFullException {
        Scanner scanner = new Scanner(System.in);
        List<String> participants = new ArrayList<>();
        Collections.addAll(participants, "Matt", "Sam");
        // Collections.addAll(participants, "Matt", "Sam", "Denise");

        try {
            System.out.print("Name of the attendee: ");
            String name = scanner.nextLine();

            checkIfEventIsFull(participants);
            participants.add(name);
            System.out.printf("%s added to the event. Full attendees list: %s", name, participants);
        } catch (EventFullException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void checkIfEventIsFull(List<String> participants) throws EventFullException {
        if (participants.size() >= 3) {
            throw new EventFullException("Sorry, this event cannot accept any more participants.");
        }
    }
}

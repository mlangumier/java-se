package src.fr.training.exceptions.students_file;

import src.fr.training.exceptions.students_file.exceptions.StringLengthException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Path filePath = Paths.get("src/fr/training/exceptions/students_file", "students.csv");
    private static final List<String> lines = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // resetFile();
            lines.addAll(Files.readAllLines(filePath));
            System.out.println("Initial file reading: " + lines);

            System.out.print("Add a new student: ");
            String studentName =  scanner.nextLine().trim();

            addStudent(studentName);

            System.out.println("New file reading: " + lines);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (StringLengthException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addStudent(String studentName) throws IOException, StringLengthException {
        checkNameLength(studentName);

        lines.add(studentName);
        Files.write(filePath, lines);
    }

    public static void checkNameLength(String name) throws StringLengthException  {
        if(name.isEmpty() || name.length() > 20) {
            throw new StringLengthException("Your name must contain between 1 and 20 characters.");
        }
    }

    public static void resetFile() throws IOException {
        lines.clear();
        lines.add("Matt");
        lines.add("Sam");
        lines.add("Henry");

        Files.write(filePath, lines);
    }
}

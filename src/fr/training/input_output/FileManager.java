package src.fr.training.input_output;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Creating a Singleton to manage writing data inside the file
 * Guide: https://medium.com/@p.osinaga/using-singleton-in-java-b1b78cf640ed
 */
public class FileManager {
    private final String file = "grades.txt";
    private PrintWriter writer;

    /**
     * Constructor
     * @param studentId Identifier of the student, used
     */
    private FileManager(String studentId) {
        try {
            FileWriter fileWriter = new FileWriter(studentId + "-" + file);
            writer = new PrintWriter(fileWriter, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package inputOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Mark recorder app - User input & read/write a file
 */
public class GradeRecorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> grades = new HashMap<String, String>();

        while(true) {
            System.out.println("\n--- Let's enter your grades ---");

            // Ask name
            String name = recordName(scanner);

            System.out.println();

            // Ask classes names + grades (iteration: 3)
            recordGrade(scanner, grades, 3);

            System.out.println();

            // Display summary
            displayGrades(grades);
            // Calc avg
            calcAvgGrades(grades);


            // Save data in file (& use Singleton?)
            // Read & display file (& use Singleton?)
            break;
        }
        scanner.close();
    }

    private static String recordName(Scanner scanner) {
        System.out.println();
        System.out.print("Your name: ");
        return scanner.nextLine().toLowerCase();
    }

    private static void recordGrade(Scanner scanner, HashMap<String, String> grades, int iterator) {
        for (int i = 0; i < iterator; i++) {
            System.out.println();

            System.out.printf("--- Exam %s%n", i+1);
            System.out.print("Class: ");
            String classExam = scanner.nextLine().toLowerCase();

            double grade = 0;
            do {
                System.out.print("Grade: ");
                grade = scanner.nextDouble();
                scanner.nextLine();
            } while (grade < 0 || grade > 20);

            grades.put(classExam, Double.toString(grade));
        }
    }

    private static void calcAvgGrades(HashMap<String, String> grades) {
        double avgGrades = 0;
        for(Map.Entry<String, String> grade: grades.entrySet()) {
            avgGrades += Double.parseDouble(grade.getValue());
        }
        System.out.printf("--- Average: %s/20%n", Math.round((avgGrades / grades.size()) * 10.0) / 10.0);
    }

    private static void displayGrades(HashMap<String, String> grades) {
        System.out.println("--- Grades");
        for(Map.Entry<String, String> grade: grades.entrySet()) {
            System.out.printf("%s: %s/20%n", grade.getKey(), grade.getValue());
        }
    }


}

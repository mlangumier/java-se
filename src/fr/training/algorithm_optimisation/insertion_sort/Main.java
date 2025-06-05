package src.fr.training.algorithm_optimisation.insertion_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //--- Insertion sort - Sort by alphabetic order (asc)

        String[] fruits = {"kiwi", "apple", "blueberry", "pineapple", "Apple", "apricot"};

        System.out.println("\n--- Start: " + Arrays.toString(fruits));

        insertSort(fruits);

        System.out.println("--- Final: " + Arrays.toString(fruits));
    }

    public static void insertSort(String[] fruits) {
        for (int i = 1; i < fruits.length; i++) {
            String key = fruits[i];
            int j = i - 1;

            while (j >= 0 && fruits[j].toLowerCase().compareTo(key.toLowerCase()) > 0) {
                System.out.printf("Sort: j=%s, i=%s ", fruits[j], key);
                fruits[j + 1] = fruits[j];
                System.out.printf("-> j=%s, j+1=%s", fruits[j], fruits[j + 1]);
                j--;
            }

            fruits[j + 1] = key;
            System.out.printf("%n| j+1=%s -> i=%s %n", fruits[j + 1], key);
        }
    }
}

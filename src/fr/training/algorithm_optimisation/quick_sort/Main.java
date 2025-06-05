package src.fr.training.algorithm_optimisation.quick_sort;

import java.util.Arrays;

// TODO: finish this
public class Main {
    public static void main(String[] args) {
        //--- Quick sort (recursive) - Sort by value (asc)
        int[] tab = {29, 10, 14, 37, 13}; // Expects: [10, 13, 14, 29, 37]

        // Choose a value in the array to be the pivot element.
        int pivotIndex = findMinInArray(tab);
        sort(tab, pivotIndex, tab.length - 1);


        System.out.println("Result: " + Arrays.toString(tab) + "\nExpected: [10, 13, 14, 29, 37]");
    }

    public static void sort(int[] tab, int startIndex, int endIndex) {
        // Order the rest of the array so that lower values than the pivot element are on the left, and higher values are on the right.
        // Swap the pivot element with the first element of the higher values so that the pivot element lands in between the lower and higher values.
        // Do the same operations (recursively) for the sub-arrays on the left and right side of the pivot element.
    }

    public static int findMinInArray(int[] tab) {
        int minIndex = tab[0];

        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] < minIndex) {
                minIndex = i;
            }
        }

        return minIndex;
    }
}

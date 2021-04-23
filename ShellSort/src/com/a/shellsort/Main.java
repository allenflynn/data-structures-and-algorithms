package com.a.shellsort;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // Insertion sort variation
        // Does some preliminary work (using gap values greater than 1), and then becomes insertion sort
        // Goal is to reduce the amount of shifting required
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            // decrease the gap until 1

            // Insertion sort with gap
            for (int i = gap; i < intArray.length; i++) {
                // outer loop starts out from the gap and grows by one after each iteration (from left to right)

                int insertedValue = intArray[i];

                int j; //insertion point
                for (j = i; j > 0 && intArray[j - gap] > insertedValue; j -= gap) {
                    // inner loop traversing the sorted partition with gap (from right to left) and
                    // shifting elements to the right if they are greater than the inserted value
                    intArray[j] = intArray[j - gap];
                }

                intArray[j] = insertedValue;
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + "  ");
        }
    }
}

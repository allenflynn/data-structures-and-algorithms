package com.a.insertionsort;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // Inserting the value into its correct position in the sorted partition (sorting in ascending order)
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            // outer loop grows the sorted partition by one after each iteration (from left to right)

            int insertedValue = intArray[firstUnsortedIndex];

            int i; // insertion point
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > insertedValue; i--) {
                // inner loop traversing the sorted partition (from right to left) and
                // shifting elements to the right if they are greater than the inserted value
                intArray[i] = intArray[i -1];
            }

            intArray[i] = insertedValue;
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}

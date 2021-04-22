package com.a.selectionsort;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // Selecting the large values to the end of the array (sorting in ascending order)
        for (int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            // outer loop grows the sorted partition by one after each iteration (from right to left)
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                // inner loop looks for the largest value in the unsorted partition (from left to right)
                if (intArray[largest] < intArray[i]) {
                    largest = i;
                }
            }

            // swap the largest value with the last element in the unsorted partition
            swap(intArray, largest, lastUnsortedIndex);
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + "  ");
        }
    }


    public static  void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
package com.a.quicksort;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        quickSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void quickSort(int[] input, int start, int end) {
        // When dealing with one element array (breaking condition)
        // end is one greater than the last valid index
        if (end - start < 2 ) {
            return;
        }

        // The index of the pivot when the array is sorted
        int pivotIndex = partition(input, start, end);

        // Recursively sort the left partition
        quickSort(input, start, pivotIndex);
        // Recursively sort the right partition
        quickSort(input,pivotIndex + 1, end);
    }

    // Elements to the left of the pivot will be smaller than the pivot
    // Elements to the right will be larger
    public static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start; // i is going to be traversing from left to right
        int j = end; // j is going to be traversing from right to left

        // Do the traversal until i and j cross each other
        while (i < j) {
            // Keep decrementing j until finding the element less than the pivot and move it to the left
            // or stop when j crosses i
            while (i < j && input[--j] >= pivot);
            if (i < j) {
                input[i] = input[j];
            }

            // Keep incrementing i until finding the element greater than the pivot and move it to the right
            // or stop when i crosses j
            while (i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }
        }

        // Set pivot and return it's index
        input[i] = pivot;
        return i;
    }

}

package com.a.mergesort;

public class Main {

    public static void main(String[] args) {
	    int[] intArray = {20, 35, -15, 7, 55, 1, -22};

	    mergeSort(intArray, 0, intArray.length);

	    for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    // Logical splitting and then merging (divide and conquer algorithms)
    public static void mergeSort(int[] input, int start, int end) {
        // The input array has been split into one element array (breaking condition)
        // end is one greater than the last valid index
        if (end - start < 2) {
            return;
        }

        // Splitting phase (logical partition)
        int mid = (start + end) / 2; // mid is one greater than the last element index of the left partition
        // recursively sort the left partition: {20, 35, -15}
        mergeSort(input, start, mid);
        // recursively sort the right partition: {7, 55, 1, -22}
        mergeSort(input, mid, end);

        // Merging phase
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        // The left and right partitions are already sorted
        if (input[mid - 1] <= input[mid]) {
            // the last element in the left partition is less than or equal to the first element in the right partition
            return;
        }

        // Copy elements into the temporary array in sorted (ascending) order
        int[] tmpArray = new int[end - start];

        int tmpIndex = 0; // tracking current position in the temporary array

        int left = start; // tracking current position in the left partition
        int right = mid; // tracking current position in the right partition

        while (left < mid && right < end) {
            // keep copying until finish the left or right partition
            tmpArray[tmpIndex++] = input[left] <= input[right] ? input[left++] : input[right++];
        }

        // Copy the remaining elements in the left partition into the original array
        System.arraycopy(input, left, input, start + tmpIndex, mid - left);

        // Copy elements in the temporary array into the original array
        System.arraycopy(tmpArray, 0, input, start, tmpIndex);
    }
}

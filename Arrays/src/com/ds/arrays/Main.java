package com.ds.arrays;

public class Main {

    public static void main(String[] args) {
	    // Contiguous block in memory
        // Every element occupies the same amount of space in memory (4 bytes)
        int[] intArray = new int[11];

        intArray[0] = 0;
        intArray[1] = 1;
        intArray[2] = 2;
        intArray[3] = 3;
        intArray[4] = 4;
        intArray[5] = 5;
        intArray[6] = 6;
        intArray[7] = 7;
        intArray[8] = 8;
        intArray[9] = 9;
        intArray[10] = -1;

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}

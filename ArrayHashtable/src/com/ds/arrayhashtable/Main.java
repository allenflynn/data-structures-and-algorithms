package com.ds.arrayhashtable;

public class Main {

    public static void main(String[] args) {
        Customer customerOne = new Customer(1, "One");
        Customer customerTwo = new Customer(2, "Two");
        Customer customerThree = new Customer(3, "Three");
        Customer customerFour = new Customer(4, "Four");
        Customer customerFive = new Customer(5, "Five");
        Customer customerSix = new Customer(6, "Six");
        Customer customerSeven = new Customer(7, "Seven");
        Customer customerEight = new Customer(8, "Eight");
        Customer customerNine = new Customer(9, "Nine");

        // Retrieve items in constant time by using non-integer keys
        ArrayHashtable hashtable = new ArrayHashtable();

        hashtable.put("one", customerOne);
        hashtable.put("two", customerTwo);
        hashtable.put("three", customerThree);
        hashtable.put("four", customerFour);
        hashtable.put("five", customerFive);
        System.out.println("\nAfter putting into the hashtable");
        hashtable.printHashtable();

        System.out.println("\nAfter getting from the hashtable");
        System.out.println(hashtable.get("four"));
        System.out.println("Key: four");

        hashtable.remove("two");
        hashtable.remove("three");
        System.out.println("\nAfter removing from the hashtable");
        hashtable.printHashtable();

        System.out.println("\nAfter getting from the hashtable");
        System.out.println(hashtable.get("four"));
        System.out.println("Key: four");

        hashtable.remove("o");
        System.out.println("\nAfter removing from the hashtable at null position");
        hashtable.printHashtable();
    }
}

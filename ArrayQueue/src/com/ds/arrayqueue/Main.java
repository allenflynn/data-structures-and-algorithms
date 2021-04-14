package com.ds.arrayqueue;

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

        // FIFO (first in first out)
        ArrayQueue queue = new ArrayQueue(3);

        queue.add(customerOne);
        queue.add(customerTwo);
        System.out.println("After adding to the queue");
        queue.printQueue();

        queue.remove();
        System.out.println("\nAfter removing from the queue");
        queue.printQueue();

        queue.add(customerThree);
        System.out.println("\nAfter adding to the queue");
        queue.printQueue();

        queue.remove();
        System.out.println("\nAfter removing from the queue");
        queue.printQueue();

        queue.add(customerFour);
        System.out.println("\nAfter adding to the queue");
        queue.printQueue();

        queue.add(customerFive);
        System.out.println("\nAfter adding to the queue");
        queue.printQueue();

        queue.add(customerSix);
        System.out.println("\nAfter adding to the queue");
        queue.printQueue();

        queue.add(customerSeven);
        System.out.println("\nAfter adding to the queue");
        queue.printQueue();

        queue.add(customerEight);
        System.out.println("\nAfter adding to the queue");
        queue.printQueue();

        queue.add(customerNine);
        System.out.println("\nAfter adding to the queue");
        queue.printQueue();

    }
}

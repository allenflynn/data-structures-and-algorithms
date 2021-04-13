package com.ds.arrayqueue;

public class Main {

    public static void main(String[] args) {
        Customer customerOne = new Customer(1, "One");
        Customer customerTwo = new Customer(2, "Two");
        Customer customerThree = new Customer(3, "Three");
        Customer customerFour = new Customer(4, "Four");
        Customer customerFive = new Customer(5, "Five");

        // FIFO (first in first out)
        ArrayQueue queue = new ArrayQueue(10);

        queue.add(customerOne);
        queue.add(customerTwo);
        queue.add(customerThree);
        queue.add(customerFour);
        queue.add(customerFive);
        System.out.println("After adding to the queue");
        queue.printQueue();

        queue.remove();
        queue.remove();
        System.out.println("\nAfter removing from the queue");
        queue.printQueue();

        System.out.println("\nPeeked: " + queue.peek());
        System.out.println("After peeking from the queue");
        queue.printQueue();

        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println("\nAfter completely removing from the queue");
        queue.printQueue();

        System.out.println("\nAfter removing from the empty queue");
        queue.remove();
    }
}

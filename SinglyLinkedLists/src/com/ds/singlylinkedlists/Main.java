package com.ds.singlylinkedlists;

public class Main {

    public static void main(String[] args) {

        Customer customerOne = new Customer(1, "One");
        Customer customerTwo = new Customer(2, "Two");
        Customer customerThree = new Customer(3, "Three");

        // Singly linked list is best used when inserting and removing items from the front of the list
        // Can continue to grow without having to be resized (compared with arrays)
        CustomerLinkedList list = new CustomerLinkedList();

        System.out.println(list.isEmpty() + "\n");

        list.addToFront(customerOne);
        list.addToFront(customerTwo);
        list.addToFront(customerThree);

        list.printList();
        System.out.println(list.getSize() + "\n");

        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());

    }
}

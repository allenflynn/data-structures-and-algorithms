package com.ds.doublylinkedlists;

public class Main {

    public static void main(String[] args) {
        Customer customerOne = new Customer(1, "One");
        Customer customerTwo = new Customer(2, "Two");
        Customer customerThree = new Customer(3, "Three");
        Customer customerFour = new Customer(4, "Four");
        Customer customerFive = new Customer(5, "Five");

        CustomerLinkedList list = new CustomerLinkedList();

        System.out.println("Empty: " + list.isEmpty() + "\n");

        list.addToFront(customerOne);
        list.addToFront(customerTwo);
        list.addToFront(customerThree);
        System.out.println("After adding to the front");
        list.printList();
        System.out.println("Size: " + list.getSize() + "\n");

        list.addToEnd(customerFour);
        list.addToEnd(customerFive);
        System.out.println("After adding to the end");
        list.printList();
        System.out.println("Size: " + list.getSize() + "\n");

        list.removeFromFront();
        System.out.println("After removing from the front");
        list.printList();
        System.out.println("Size: " + list.getSize() + "\n");

        list.removeFromEnd();
        System.out.println("After removing from the end");
        list.printList();
        System.out.println("Size: " + list.getSize() + "\n");
    }
}

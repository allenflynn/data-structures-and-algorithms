package com.ds.doublylinkedlists;

public class Main {

    public static void main(String[] args) {
        Customer customerOne = new Customer(1, "One");
        Customer customerTwo = new Customer(2, "Two");
        Customer customerThree = new Customer(3, "Three");
        Customer customerFour = new Customer(4, "Four");
        Customer customerFive = new Customer(5, "Five");

        CustomerLinkedList list = new CustomerLinkedList();

        System.out.println("List is empty: " + list.isEmpty() + "\n");

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

        Customer customerSix = new Customer(6, "Six");
        list.addBefore(customerSix, customerThree);
        System.out.println("After adding before the existing (head)");
        list.printList();
        System.out.println("Size: " + list.getSize() + "\n");

        Customer customerSeven = new Customer(7, "Seven");
        list.addBefore(customerSeven, customerOne);
        System.out.println("After adding before the existing");
        list.printList();
        System.out.println("Size: " + list.getSize() + "\n");

        Customer customerEight = new Customer(8, "Eight");
        list.addBefore(customerEight, new Customer(9, "Nine"));
        System.out.println("After adding before the existing (not in the list)");
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

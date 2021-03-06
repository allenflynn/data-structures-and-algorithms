package com.ds.linkedliststack;

public class Main {

    public static void main(String[] args) {
        // LIFO (last in first out)
        LinkedListStack stack = new LinkedListStack();

        stack.push(new Customer(1, "One"));
        stack.push(new Customer(2, "Two"));
        stack.push(new Customer(3, "Three"));
        stack.push(new Customer(4, "Four"));
        stack.push(new Customer(5, "Five"));
        System.out.println("After pushing");
        stack.printStack();

        System.out.println("\nPeeked: " + stack.peek());

        System.out.println("\nAfter peeking");
        stack.printStack();

        System.out.println("\nPopped: " + stack.pop());
        System.out.println("\nAfter popping");
        stack.printStack();
    }
}

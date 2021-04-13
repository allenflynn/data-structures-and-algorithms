package com.ds.linkedliststack;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListStack {
    private LinkedList<Customer> stack;

    public LinkedListStack() {
        stack = new LinkedList<Customer>();
    }

    public void push(Customer customer) {
        stack.push(customer);
    }

    public Customer pop() {
        return stack.pop();
    }

    public Customer peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Customer> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

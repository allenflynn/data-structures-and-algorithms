package com.ds.arraystack;

import java.util.EmptyStackException;

public class ArrayStack {
    private Customer[] stack;
    private int topIndex = -1;

    // The capacity of the stack
    public ArrayStack(int capacity) {
        stack = new Customer[capacity];
    }

    public void push(Customer customer) {
        if (topIndex + 1 == stack.length ) {
            // If the stack is full, resize the backing array (double the capacity)
            Customer[] newStack = new Customer[2 * stack.length];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[++topIndex] = customer;
    }

    public Customer pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Customer customer = stack[topIndex];
        stack[topIndex--] = null;
        return customer;
    }

    public Customer peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[topIndex];
    }

    public int size() {
        return topIndex + 1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void printStack() {
        for (int i = topIndex; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }
}

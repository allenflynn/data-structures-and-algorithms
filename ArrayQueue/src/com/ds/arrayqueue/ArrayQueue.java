package com.ds.arrayqueue;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private Customer[] queue;
    private int head;
    private int tail;

    // The capacity of the queue
    public ArrayQueue(int capacity) {
        queue = new Customer[capacity];
    }

    public void add(Customer customer) {
        // If the queue is full, resize the backing array (double the capacity)
        if (size() == queue.length -1) {
            // The number of items before unwrapping
            int numItems = size();

            Customer[] newQueue = new Customer[2 * queue.length];
            // Unwrap head back to the front of the queue
            System.arraycopy(queue, head, newQueue, 0, queue.length - head);
            // Unwrap tailIndex back to the end of the queue
            System.arraycopy(queue, 0 , newQueue, queue.length - head, tail);
            queue = newQueue;

            head = 0;
            tail = numItems;

            System.out.println("\n*** Resizing ***");
        }

        // The tail points to the next available position
        queue[tail++] = customer;
        // If the queue is not full and tail is hitting the end
        if (tail == queue.length) {
            // Wrap tail to the front of the queue
            tail = 0;

            System.out.println("\n*** Wrapping ***");
        }
    }

    public Customer remove() {
        if (size() == 0) {
            // Remove from empty queue
            throw new NoSuchElementException();
        } else if (head == queue.length) {
            // Wrap head back to the front of the queue
            head = 0;
        }

        Customer customer = queue[head];
        queue[head] = null;
        if (size() == 1) {
            // Remove the only item on the queue
            head = 0;
            tail = 0;
        } else {
            // The head points to the currently existing position
            head++;
        }

        return customer;
    }

    public Customer peek() {
        if (size() == 0) {
            // Remove from empty queue
            throw new NoSuchElementException();
        }

        return queue[head];
    }

    public int size() {
        if (head <= tail) {
            // Items size on the queue
            return tail - head;
        } else {
            // The queue has wrapped
            return tail - head + queue.length;
        }
    }

    public void printQueue() {
        if (head <= tail) {
            for (int i = head; i < tail; i++) {
                System.out.println(queue[i]);
            }

            System.out.println("Head: " + head);
            System.out.println("Tail: " + tail);
        } else {
            // The queue has wrapped
            for (int i = head; i < queue.length; i++ ) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < tail; i++) {
                System.out.println(queue[i]);
            }

            System.out.println("Tail: " + tail);
            System.out.println("Head: " + head);
        }
    }

}
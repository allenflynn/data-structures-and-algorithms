package com.ds.arrayqueue;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private Customer[] queue;
    private int headIndex;
    private int tailIndex = -1;

    // The capacity of the queue
    public ArrayQueue(int capacity) {
        queue = new Customer[capacity];
    }

    public void add(Customer customer) {
        // If the queue is full, resize the backing array (double the capacity)
        if (tailIndex + 1 == queue.length) {
            Customer[] newQueue = new Customer[2 * queue.length];
            System.arraycopy(queue, 0 , newQueue, 0, queue.length);
            queue = newQueue;
        }

        queue[++tailIndex] = customer;
    }

    public Customer remove() {
        if (size() == 0) {
            // Remove from empty queue
            throw new NoSuchElementException();
        }

        Customer customer = queue[headIndex];
        queue[headIndex] = null;
        if (size() == 1) {
            // Remove the only item on the queue
            headIndex = 0;
            tailIndex = -1;
        } else {
            headIndex++;
        }

        return customer;
    }

    public Customer peek() {
        if (size() == 0) {
            // Remove from empty queue
            throw new NoSuchElementException();
        }

        return queue[headIndex];
    }

    public int size() {
        // Items size on the queue
        return tailIndex + 1 - headIndex;
    }

    public void printQueue() {
        for (int i = headIndex; i <= tailIndex; i++) {
            System.out.println(queue[i]);
        }
    }

}

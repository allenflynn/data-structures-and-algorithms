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
        if (size() == queue.length) {
            // The number of items before unwrapping
            int numItems = size();

            Customer[] newQueue = new Customer[2 * queue.length];
            // Unwrap headIndex back to the front of the queue
            System.arraycopy(queue, headIndex, newQueue, 0, queue.length - headIndex);
            // Unwrap tailIndex back to the end of the queue
            System.arraycopy(queue, 0 , newQueue, queue.length - headIndex, tailIndex + 1);
            queue = newQueue;

            headIndex = 0;
            tailIndex = numItems -1;
        }

        if (tailIndex == queue.length - 1) {
            // Wrap tailIndex to the front of the queue
            tailIndex = 0;
            queue[tailIndex] = customer;
        } else {
            queue[++tailIndex] = customer;
        }

    }

    public Customer remove() {
        if (size() == 0) {
            // Remove from empty queue
            throw new NoSuchElementException();
        } else if (headIndex == queue.length) {
            // Wrap headIndex back to the front of the queue
            headIndex = 0;
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
        if (tailIndex == -1) {
            return 0;
        }
        if (headIndex <= tailIndex) {
            // Items size on the queue
            return tailIndex - headIndex + 1;
        } else {
            // The queue has wrapped
            return queue.length - (headIndex - tailIndex) + 1;
        }
    }

    public void printQueue() {
       if (headIndex <= tailIndex) {
            for (int i = headIndex; i <= tailIndex; i++) {
                System.out.println(queue[i]);
            }
        } else {
            // The queue has wrapped
            for (int i = headIndex; i < queue.length; i++ ) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i <= tailIndex; i++) {
                System.out.println(queue[i]);
            }
        }
    }

}

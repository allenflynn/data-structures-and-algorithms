package com.ds.maxheaps;

public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        // add new values to the end of the array (nodes are added at each level from left to right)
        heap[size] = value;
        // heapify the heap (if the value is greater than its parent, swap it with its parent)
        fixHeapAbove(size);

        // next available position
        size++;
    }

    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        // the deleted node
        int deletedNode = heap[index];
        // the parent node of the deleted one
        int parentNode = heap[parent(index)];

        // the replacement node (the right-most node in the heap)
        int replacementNode = heap[size -1];
        // replace the deleted node with the replacement node, so that the tree remains complete
        heap[index] = replacementNode;

        if (replacementNode < parentNode || index == 0) {
            // the replacement node is less than the parent node or delete the root node
            fixHeapBelow(index);
        } else {
            // the replacement node is greater than the parent node
            fixHeapAbove(index);
        }

        // next available position
        size--;

        return deletedNode;
    }

    public void fixHeapAbove(int index){
        // the current node
        int currentNode = heap[index];
        // the final position where the current node belong
        int position = index;

        // The child node is greater than parent node
        while (index > 0 && heap[index] > heap[parent(index)]) {
            // set parent node to child node
            heap[index] = heap[parent(index)];
            // move to the position of parent node
            position = parent(index);
        }

        heap[position] = currentNode;
    }

    public void fixHeapBelow(int index) {
        // the current heap size (size points to the next available position)
        int currentSize = size - 1;

        // the child node to swap
        int position;

        while (index <= currentSize) {
            int leftNodeIndex = child(index, true);
            int rightNodeIndex = child(index, false);

            // Left node exists
            if (leftNodeIndex <= currentSize) {
                if (rightNodeIndex > currentSize) {
                    // right node doesn't exist (swap with the left node)
                    position = leftNodeIndex;
                } else {
                    // right node exists (swap with the larger of the two)
                    position = heap[leftNodeIndex] > heap[rightNodeIndex] ? leftNodeIndex : rightNodeIndex;
                }

                if (heap[position] > heap[index]) {
                    // if the child node is greater than parent node, swap them
                    int tmp = heap[index];
                    heap[index] = heap[position];
                    heap[position] = tmp;
                } else {
                    break;
                }

                // keep checking to see if there's more swapping needed between parent node and child node
                index = position;
            } else {
                // left node doesn't exist (the leaf node)
                break;
            }
        }
    }

    public boolean isFull() {
        return heap.length == size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Index of the parent node
    // floor(index -1) / 2
    public int parent(int index) {
        return (index - 1) / 2;
    }

    // Index of the child node
    // left child node: 2 * index + 1
    // right child node: 2 * index + 2
    public int child(int index, boolean isLeftNode) {
        return 2 * index + (isLeftNode ? 1 : 2);
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println("\n");
    }
}

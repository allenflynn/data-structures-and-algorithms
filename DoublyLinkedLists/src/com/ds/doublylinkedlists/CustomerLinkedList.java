package com.ds.doublylinkedlists;

public class CustomerLinkedList {

    private CustomerNode headNode;
    private CustomerNode tailNode;
    private int size;

    public void addToFront(Customer customer) {
        // The previous node of the current will always be null
        CustomerNode currentNode = new CustomerNode(customer);

        if (headNode == null) {
            // Adding this node into an empty list
            tailNode = currentNode;
        } else {
            // Adding this node into an non-empty list
            currentNode.setNextNode(headNode);
            headNode.setPreviousNode(currentNode);
        }

        headNode = currentNode;
        size++;
    }

    public void addToEnd(Customer customer) {
        // The next node of the current will always be null
        CustomerNode currentNode = new CustomerNode(customer);

        if (headNode == null) {
            // Adding this node into an empty list
            headNode = currentNode;
        } else {
            // Adding this node into an non-empty list
            currentNode.setPreviousNode(tailNode);
            tailNode.setNextNode(currentNode);
        }

        tailNode = currentNode;
        size++;
    }

    public CustomerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        CustomerNode removedNode = headNode;

        if (headNode.getNextNode() == null) {
            // Removing the only node in the list
            headNode = null;
            tailNode = null;
        } else {
            headNode.getNextNode().setPreviousNode(null);
        }
        headNode = headNode.getNextNode();
        size--;
        removedNode.setNextNode(null);
        return removedNode;
    }

    public CustomerNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        CustomerNode removedNode = tailNode;

        if (headNode.getNextNode() == null) {
            // Removing the only node in the list
            headNode = null;
            tailNode = null;
        } else {
            tailNode.getPreviousNode().setNextNode(null);
        }
        tailNode = tailNode.getPreviousNode();
        size--;
        removedNode.setPreviousNode(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public void printList() {
        CustomerNode currentNode = headNode;
        while (currentNode != null) {
            System.out.println(currentNode.getCustomer());
            currentNode = currentNode.getNextNode();
        }
    }
}

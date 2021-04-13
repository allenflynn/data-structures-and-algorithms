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

    public boolean addBefore(Customer newCustomer, Customer existingCustomer) {
        if (isEmpty()) {
            return false;
        }

        // Find the existing customer node
        CustomerNode existingNode = headNode;
        while (existingNode != null && !existingNode.getCustomer().equals(existingCustomer)) {
            existingNode = existingNode.getNextNode();
        }

        if (existingNode == null) {
            // The existing customer isn't in the list
            return false;
        }

        // The previous customer node of the existing one (could be null if the existing one is head node)
        CustomerNode previousNode = existingNode.getPreviousNode();

        // The new customer node
        CustomerNode newNode = new CustomerNode(newCustomer);

        newNode.setPreviousNode(previousNode);
        newNode.setNextNode(existingNode);
        existingNode.setPreviousNode(newNode);
        if (headNode == existingNode) {
            headNode = newNode;
        } else {
            previousNode.setNextNode(newNode);
        }

        size++;

        return true;
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

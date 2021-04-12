package com.ds.singlylinkedlists;

public class CustomerLinkedList {

    private CustomerNode headNode;
    private int size;

    public void addToFront(Customer customer) {
        CustomerNode currentNode = new CustomerNode(customer);
        currentNode.setNextNode(headNode);
        headNode = currentNode;
        size++;
    }

    public CustomerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        CustomerNode removedNode = headNode;
        headNode = headNode.getNextNode();
        size--;
        removedNode.setNextNode(null);
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

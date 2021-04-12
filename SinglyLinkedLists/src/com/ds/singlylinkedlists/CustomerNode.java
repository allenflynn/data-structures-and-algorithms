package com.ds.singlylinkedlists;

public class CustomerNode {

    private Customer customer;
    private CustomerNode nextNode;

    public CustomerNode(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(CustomerNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "CustomerNode{" +
                "customer=" + customer +
                ", nextNode=" + nextNode +
                '}';
    }
}

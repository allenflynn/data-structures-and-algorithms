package com.ds.arrayhashtable;

public class ArrayHashtable {

    private CustomerNode[]  hashtable;

    public ArrayHashtable() {
        hashtable = new CustomerNode[10];
    }

    // Taking a string and hashing it to an int
    private int hashed(String key) {
        return key.length() % hashtable.length;
    }

    // If the position in the array is occupied, return true
    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public void put(String key, Customer customer) {
        int index = hashed(key);

        // Linear probing
        if (occupied(index)) {
            int stopIndex = index;
            // first probing
            if (index == hashtable.length -1) {
                // wrapping (check from the start when hitting the end)
                index = 0;
            } else {
                index++;
            }
            // probing the rest
            while (occupied(index) && index != stopIndex) {
                // check to see if the next position is available
                index = (index + 1) % hashtable.length;
            }
        }

        if (occupied(index)) {
            // no position available after checking the entire array
            System.out.println("There is no position available at index " + index);
        } else {
            // assign value into it
            hashtable[index] = new CustomerNode(key, customer);
        }
    }

    public int findHashed(String key) {
        int index = hashed(key);
        CustomerNode customerNode = hashtable[index];

        // The key stored in customerNode (which is the value stored in the hashtable) is found
        if (customerNode != null && customerNode.key.equals(key)) {
            return index;
        }

        // If key is not found, do the linear probing
        int stopIndex = index;
        // first probing
        if (index == hashtable.length - 1) {
            // wrapping (check from the start when hitting the end)
            index = 0;
        } else {
            index++;
        }
        // probing the rest
        while (hashtable[index] != null && !hashtable[index].key.equals(key) && index != stopIndex) {
            // check to see if next position has the matched key
            index++;
        }

        if (hashtable[index] != null && hashtable[index].key.equals(key)) {
            // key is found after probing
            return index;
        } else {
            return -1;
        }
    }

    public Customer get(String key) {
        int index = findHashed(key);
        if (index == -1) {
            return null;
        }

        // retrieve value (in constant time)
        return hashtable[index].customer;
    }

    public Customer remove(String key) {
        int index = findHashed(key);
        if (index == -1) {
            return null;
        }
        Customer customer = hashtable[index].customer;
        hashtable[index] = null;

        // Rehashing to make the existing values in hashtable without null value in between
        CustomerNode[] oldHashtable = hashtable;
        hashtable = new CustomerNode[hashtable.length];
        for (int i = 0; i < hashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].customer);
            }
        }

        return customer;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                System.out.println(hashtable[i].customer + " at position " + i);
            } else {
                System.out.println("Position " + i + " is null");
            }
        }
    }
}

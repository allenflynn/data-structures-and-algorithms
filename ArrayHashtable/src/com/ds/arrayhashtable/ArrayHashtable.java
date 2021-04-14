package com.ds.arrayhashtable;

public class ArrayHashtable {

    //private Customer[] hashtable;
    private CustomerNode[]  hashtable;

    public ArrayHashtable() {
        hashtable = new CustomerNode[10];
    }

    private int hash(String key) {
        // Taking a string and hashing it to an int
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index) {
        // If the position in the array is occupied, return true
        return hashtable[index] != null;
    }

    public void put (String key, Customer customer) {
        int hashedKey = hash(key);

        // Linear probing
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            // First probing
            if (hashedKey == hashtable.length -1) {
                // Wrapping (check from the start when hitting the end)
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            // Probing the rest
            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (occupied(hashedKey)) {
            // The entire array has been checked
            System.out.println("There is no position available at index " + hashedKey);
        } else {
            // If the position in the array is available, assign value into it
            hashtable[hashedKey] = new CustomerNode(key, customer);
        }
    }

    public Customer get(String key) {
        int hashedKey = findHashedKey(key);
        if (hashedKey == -1) {
            return null;
        }
        // Retrieve value in constant time
        return hashtable[hashedKey].customer;
    }

    public int findHashedKey(String key) {
        int hashedKey = hash(key);
        CustomerNode customerNode = hashtable[hashedKey];

        if (customerNode != null && customerNode.key.equals(key)) {
            // The key stored in the hashtable is as expected
            return hashedKey;
        }

        // Linear probing
        int stopIndex = hashedKey;
        // First probing
        if (hashedKey == hashtable.length - 1) {
            // Wrapping (check from the start when hitting the end)
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        // Probing the rest
        while (customerNode != null && !hashtable[hashedKey].key.equals(key) && hashedKey != stopIndex) {
            hashedKey++;
        }

        if (hashedKey == stopIndex) {
            return -1;
        } else {
            // The key stored in the hashtable is as expected after probing
            return hashedKey;
        }
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                System.out.println(hashtable[i].customer);
            }
        }
    }
}

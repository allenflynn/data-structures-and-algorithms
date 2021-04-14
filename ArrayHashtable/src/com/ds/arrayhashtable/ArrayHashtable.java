package com.ds.arrayhashtable;

public class ArrayHashtable {

    private Customer[] hashtable;

    public ArrayHashtable() {
        hashtable = new Customer[10];
    }

    private int hash(String key) {
        // Taking a string and hashing it to an int
        return key.length() % hashtable.length;
    }

    public void put (String key, Customer customer) {
        int hashedKey = hash(key);
        if (hashtable[hashedKey] != null) {
            System.out.println("There is no position available at index " + hashedKey);
        } else {
            // If the position in the array is available, assign value into it
            hashtable[hashedKey] = customer;
        }
    }

    public Customer get(String key) {
        int hashedKey = hash(key);
        // Retrieve value in constant time
        return hashtable[hashedKey];
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            System.out.println(hashtable[i]);
        }
    }
}

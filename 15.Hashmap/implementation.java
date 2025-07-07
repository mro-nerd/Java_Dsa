/*Design a Hashmap with put(), get() and remove() method in most optimal way. */

import java.util.*;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class  MyHashMap {
    private final int INITIAL_SIZE = 16;
    private final double MAX_LOAD_FACTOR = 0.75;
    private ArrayList<LinkedList<Pair<Integer, Integer>>> arr;
    private int curSize, curBuckets;

    private int hash(int key) {
        return key % curBuckets; // [0, curBuckets - 1] 
    }

    private void rehash() {
        ArrayList<LinkedList<Pair<Integer, Integer>>> arr2 = new ArrayList<>();

        // Number of buckets doubled.
        curBuckets *= 2;
        for (int i = 0; i < curBuckets; ++i) {
            arr2.add(new LinkedList<>());
        }

        // Go to all the elements in the old Array & add to new Array
        for (LinkedList<Pair<Integer, Integer>> ll : arr) {
            Iterator<Pair<Integer, Integer>> it = ll.iterator();
            while (it.hasNext()) {
                Pair<Integer, Integer> curPair = it.next();
                int newId = hash(curPair.getKey());
                arr2.get(newId).addFirst(curPair);
            }
        }

        arr = arr2; // Update the arr;
    }

    private double curLoadFactor() {
        return curSize / (double) curBuckets;
    }

    private int get(LinkedList<Pair<Integer, Integer>> ll, int key) //getting keyId of given linked list at given index of bucket
    {
        Iterator<Pair<Integer, Integer>> it = ll.iterator();
        int id = 0;
        while (it.hasNext()) {
            Pair<Integer, Integer> curPair = it.next();
            if (curPair.getKey() == key)
                return id;
            id++;
        }
        return -1;
    }

    public MyHashMap() {
        curSize = 0;
        curBuckets = INITIAL_SIZE;
        arr = new ArrayList<>();
        for (int i = 0; i < curBuckets; ++i) {
            arr.add(new LinkedList<>());
        }
    }

    public int get(int key) {
        int i = hash(key);
        Iterator<Pair<Integer, Integer>> it = arr.get(i).iterator();
        while (it.hasNext()) {
            Pair<Integer, Integer> curPair = it.next();
            if (curPair.getKey() == key)
                return curPair.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        int i = hash(key);
        int keyId = get(arr.get(i), key);

        if (keyId == -1){
            arr.get(i).addFirst(new Pair<>(key, value));
            curSize += 1;
        }    
        else {
            arr.get(i).set(keyId, new Pair<>(key, value));
        }

        if (curLoadFactor() > MAX_LOAD_FACTOR)
            rehash();
    }

    public void remove(int key) {
        int i = hash(key);
        int keyId = get(arr.get(i), key);

        if (keyId != -1) {
            arr.get(i).remove(keyId);
            curSize -= 1;
        }
    }
}



public class implementation {
    public static void main(String[] args) {
        // Instantiate MyHashMap object
        MyHashMap myHashMap = new MyHashMap();

        // Add key-value pairs
        myHashMap.put(1, 10);
        myHashMap.put(2, 20);
        myHashMap.put(3, 30);

        // Get values by keys
        System.out.println("Value for key 1: " + myHashMap.get(1)); // Output: 10
        System.out.println("Value for key 2: " + myHashMap.get(2)); // Output: 20
        System.out.println("Value for key 3: " + myHashMap.get(3)); // Output: 30

        // Remove key
        myHashMap.remove(2);
        System.out.println("Value for key 2 after removal: " + myHashMap.get(2)); // Output: -1

        // Test adding a new key after removal
        myHashMap.put(2, 25);
        System.out.println("Value for key 2 after re-adding: " + myHashMap.get(2)); // Output: 25

        
        
    }
}

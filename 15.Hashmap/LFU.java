/*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.Implement the LRUCache class:

*LRUCache(int capacity) Initialize the LRU cache with positive size capacity.

*int get(int key) Return the value of the key if the key exists, otherwise return -1.

*void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4 */

import java.util.*;

class Node {
    int key;
    Node next;
    Node prev;

    Node(int d) {
        key = d;
        next = prev = null;
    }
}

class CustomLinkedList {
    Node head;
    Node tail;
    int size;

    CustomLinkedList() {
        head = tail = null;
        size = 0;
    }

    Node pushBack(int num) {
        Node newNode = new Node(num);

        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size += 1;
        return newNode;
    }

    void delNode(Node cur) {
        if (size == 1) {
            head = tail = null;
        } else if (cur == head) {
            head = cur.next;
            head.prev = null;
        } else if (cur == tail) {
            tail = cur.prev;
            tail.next = null;
        } else {
            Node nextNode = cur.next;
            Node prevNode = cur.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size -= 1;
    }
}

class LFUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, Node> keyToNode;
    TreeMap<Integer, CustomLinkedList> freqToKeys;
    int cap;

    void evictAppropriately() {
        int minFreq = freqToKeys.firstKey();
        Node headNode = freqToKeys.get(minFreq).head;
        int culpritKey = headNode.key;

        keyToVal.remove(culpritKey);
        keyToFreq.remove(culpritKey);
        keyToNode.remove(culpritKey);
        freqToKeys.get(minFreq).delNode(headNode);
        if (freqToKeys.get(minFreq).size == 0)
            freqToKeys.remove(minFreq);
    }

    void transferFreq(int key) {
        int oldFreq = keyToFreq.get(key);
        Node nodeToDel = keyToNode.get(key);
        freqToKeys.get(oldFreq).delNode(nodeToDel);
        if (freqToKeys.get(oldFreq).size == 0)
            freqToKeys.remove(oldFreq);

        keyToFreq.put(key, oldFreq + 1);
        if (!freqToKeys.containsKey(oldFreq + 1)) {
            freqToKeys.put(oldFreq + 1, new CustomLinkedList());
        }
        freqToKeys.get(oldFreq + 1).pushBack(key);
        keyToNode.put(key, freqToKeys.get(oldFreq + 1).tail);
    }

    public LFUCache(int capacity) {
        cap = capacity;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        keyToNode = new HashMap<>();
        freqToKeys = new TreeMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key))
            return -1;

        transferFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (keyToVal.containsKey(key)) {
            transferFreq(key);
            keyToVal.put(key, value);
            return;
        }

        if (keyToVal.size() == cap) {
            evictAppropriately();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        if (!freqToKeys.containsKey(1))
            freqToKeys.put(1, new CustomLinkedList());
        freqToKeys.get(1).pushBack(key);
        keyToNode.put(key, freqToKeys.get(1).tail);
    }
}

public class LFU {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2); // Create a cache with a capacity of 2

        // Test case operations
        cache.put(1, 1); // Cache stores (1 -> 1)
        cache.put(2, 2); // Cache stores (1 -> 1), (2 -> 2)
        System.out.println(cache.get(1)); // Returns 1
        cache.put(3, 3); // Evicts key 2, stores (1 -> 1), (3 -> 3)
        System.out.println(cache.get(2)); // Returns -1 (not found)
        System.out.println(cache.get(3)); // Returns 3
        cache.put(4, 4); // Evicts key 1, stores (4 -> 4), (3 -> 3)
        System.out.println(cache.get(1)); // Returns -1 (not found)
        System.out.println(cache.get(3)); // Returns 3
        System.out.println(cache.get(4)); // Returns 4
    }
}

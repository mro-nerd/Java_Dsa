/*Implement the RandomizedSet class:

*RandomizedSet() Initializes the RandomizedSet object.

*bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.

*bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.

*int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.

You must implement the functions of the class such that each function works in average O(1) time complexity.

 

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2. */

import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> mp;
    List<Integer> v;
    Random rand;

    public RandomizedSet() {
        mp = new HashMap<>();
        v = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (mp.containsKey(val)) // check if val is present
            return false;
        mp.put(val, v.size()); // update the index
        v.add(val); // insert the value in the list
        return true;
    }

    public boolean remove(int val) {
        if (!mp.containsKey(val))
            return false;
        int index_of_val = mp.get(val);

        // update the index of the last element due to the swap
        mp.put(v.get(v.size() - 1), index_of_val);
        Collections.swap(v, index_of_val, v.size() - 1);

        // remove the last element from the list
        v.remove(v.size() - 1);
        mp.remove(val);
        return true;
    }

    public int getRandom() {
        return v.get(rand.nextInt(v.size())); // get a random element
    }
}

public class randomSet {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        // Example Test Cases
        System.out.println(randomizedSet.insert(1)); // Returns true
        System.out.println(randomizedSet.remove(2)); // Returns false (not found)
        System.out.println(randomizedSet.insert(2)); // Returns true
        System.out.println(randomizedSet.getRandom()); // Returns either 1 or 2
        System.out.println(randomizedSet.remove(1)); // Returns true
        System.out.println(randomizedSet.insert(2)); // Returns false (already present)
        System.out.println(randomizedSet.getRandom()); // Returns 2
    }
}

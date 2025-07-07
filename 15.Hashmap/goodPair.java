/*Given an array of integers nums, return the number of good pairs.A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed. */

import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count=0;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(Integer v:freq.values()){
            if(v>1)count+=(v*(v-1))/2;
        }
        return count;
    }
}

public class goodPair {
    public static void main(String[] args) {
        // Instantiate the Solution class
        Solution solution = new Solution();

        // Define test cases
        int[] nums1 = {1, 2, 3, 1, 1, 3};
        int[] nums2 = {1, 1, 1, 1};
        int[] nums3 = {1, 2, 3};

        // Call numIdenticalPairs method for each test case and print the results
        System.out.println("Number of good pairs in nums1: " + solution.numIdenticalPairs(nums1)); // Output: 4
        System.out.println("Number of good pairs in nums2: " + solution.numIdenticalPairs(nums2)); // Output: 6
        System.out.println("Number of good pairs in nums3: " + solution.numIdenticalPairs(nums3)); // Output: 0
    }
}



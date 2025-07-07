/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.You may assume that each input would have exactly one solution, and you may not use the same element twice.You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]. */

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] {numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[] {}; // No solution found
    }
}

// Main Class
public class twoSum {
    public static void main(String[] args) {
        // Sample input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the twoSum method
        int[] result = solution.twoSum(nums, target);

        // Output the result
        if (result.length == 2) {
            System.out.println("Indices of the two numbers are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}


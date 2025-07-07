/*Return the most frequent even number from the given array. If two even numbers have same max frequencies then smaller number will be returned. If no even number is found then return -1.  */

import java.util.*;

class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int maxFreqSoFar = 0, finalAns = -1;
        for (Integer num : freq.keySet()) {
            int curFreq = freq.get(num);

            if ((num % 2 == 1) || curFreq < maxFreqSoFar) {
                continue;
            }

            if (curFreq > maxFreqSoFar || num < finalAns) {
                maxFreqSoFar = curFreq;
                finalAns = num;
            }
        }
        return finalAns;
    }
}

public class frequentEvens {
    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Define input test cases
        int[] nums1 = {1, 3, 2, 8, 6, 4, 8, 4};
        int[] nums2 = {7, 5, 3, 1,1};
        int[] nums3 = {2, 2, 0, 0, 4, 4};
        
        // Call mostFrequentEven method and print results
        System.out.println("Most frequent even number in nums1: " + solution.mostFrequentEven(nums1)); // Output: 4
        System.out.println("Most frequent even number in nums2: " + solution.mostFrequentEven(nums2)); // Output: -1
        System.out.println("Most frequent even number in nums3: " + solution.mostFrequentEven(nums3)); // Output: 0
    }
}



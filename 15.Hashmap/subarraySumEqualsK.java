/*Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2
*/

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumCnt = new HashMap<>();
        preSumCnt.put(0, 1); // pre[-1]

        int preSum = 0, ans = 0;
        for (int en = 0; en < nums.length; ++en) {
            preSum += nums[en];
            
            ans += preSumCnt.getOrDefault(preSum - k, 0);
            
            int curFreq = preSumCnt.getOrDefault(preSum, 0);
            preSumCnt.put(preSum, curFreq + 1);
        }
        return ans;
    }
}

public class subarraySumEqualsK {
    public static void main(String[] args) {
        // Sample input
        int[] nums = {1, 2, 3}; // Array representing the subarray
        int k = 3; // Target sum

        // Instantiate the Solution class
        Solution solution = new Solution();

        // Call the subarraySum method and print the result
        int result = solution.subarraySum(nums, k);

        // Output the result
        System.out.println("The number of subarrays with sum equal to " + k + " is: " + result);
    }
}



/*You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.Return the maximum score you can get by erasing exactly one subarray.

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17

Explanation: The optimal subarray here is [2,4,5,6]. 

*/

import java.util.*;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0, curr_sum = 0;

        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            curr_sum += nums[j];
            while (mp.get(nums[j]) > 1) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                curr_sum -= nums[i];
                i++;
            }
            ans = Math.max(ans, curr_sum);
            j++;
        }
        return ans;
    }
}

public class maxEraseValue {
    public static void main(String[] args) {
        // Sample input
        int[] nums = { 4, 2, 4, 5, 6 };

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the maximumUniqueSubarray method
        int result = solution.maximumUniqueSubarray(nums);

        // Output the result
        System.out.println("The maximum sum of a unique subarray is: " + result);
    }
}

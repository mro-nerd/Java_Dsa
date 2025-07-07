/*You are given an array arr[] of integers. Find the total count of subarrays with their sum equal to 0.

Examples:
Input: arr[] = [6, -1, -3, 4, -2, 2, 4, 6, -12, -7]
Output: 4
Explanation: The 4 subarrays are [-1, -3, 4], [-2, 2], [2, 4, 6, -12], 
and [-1, -3, 4, -2, 2] */

import java.util.*;

// Solution class implementing the findSubarray method
class Solution {
    // Function to count subarrays with a sum equal to 0.
    public static long findSubarray(long[] arr, int n) {
        long ans = 0;
        HashMap<Long, Integer> mp = new HashMap<>();
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            
            // If the cumulative sum is 0, increment the answer as we found a zero-sum subarray
            if (sum == 0) ans++;
            
            // Check if this sum has been seen before
            ans += mp.getOrDefault(sum, 0);
            
            // Update the frequency of this sum in the map
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}

// Main class to test the findSubarray method
public class zeroSumSubArr {
    public static void main(String[] args) {
        // Test case 1
        long[] arr1 = {0, 0, 5, 5, 0, 0};
        int n1 = arr1.length;
        System.out.println("Number of zero-sum subarrays: " + Solution.findSubarray(arr1, n1));
        // Output: 6

        // Test case 2
        long[] arr2 = {1, -1, 3, -3, 4, -4, 0};
        int n2 = arr2.length;
        System.out.println("Number of zero-sum subarrays: " + Solution.findSubarray(arr2, n2));
        // Output: 7

        // Test case 3
        long[] arr3 = {3, -1, -2, 4, 2, -3, -3};
        int n3 = arr3.length;
        System.out.println("Number of zero-sum subarrays: " + Solution.findSubarray(arr3, n3));
        // Output: 3
    }
}



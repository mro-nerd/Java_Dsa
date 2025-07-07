/*Given an array containing 0s and 1s. Find the number of subarrays having equal number of 0s and 1s.

Example 1:

Input:
n = 7
A[] = {1,0,0,1,0,1,1}
Output: 8
Explanation: The index range for the 8 
sub-arrays are: (0, 1), (2, 3), (0, 3), (3, 4), 
(4, 5) ,(2, 5), (0, 5), (1, 6) */

import java.util.*;

// Solution class implementing the findSubarray method
class Solution {
    // Function to count subarrays with a sum equal to 0.
    public static long findSubarray(long[] arr, int n) {
        long ans = 0;
        HashMap<Long, Integer> mp = new HashMap<>();
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) sum -= 1;//converting above problem into zero sum subarray problem
            else sum += 1;
            
        
            if (sum == 0) ans++;
            
            
            ans += mp.getOrDefault(sum, 0);
            
            
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}

// Main class to test the findSubarray method
public class equalOnesAndZeros {
    public static void main(String[] args) {
        // Test case 1
        long[] arr1 = {1,0,0,1,0,1,1};
        int n1 = arr1.length;
        System.out.println("Number of subarrays with equal no. of 0s and 1s: " + Solution.findSubarray(arr1, n1));
        // Output: 8

        // Test case 2
        long[] arr2 = {1,1,1,1,0};
        int n2 = arr2.length;
        System.out.println("Number of subarrays with equal no. of 0s and 1s: " + Solution.findSubarray(arr2, n2));
        // Output: 1

    }
}



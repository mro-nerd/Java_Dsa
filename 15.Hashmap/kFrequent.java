/*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2] */

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int n = map.size();
        int[][] arr = new int[n][2];

        int idx = 0;
        for (Integer i : map.keySet()) {
            arr[idx][1] = i;
            arr[idx][0] = map.get(i);
            idx++;
        }
        // Sort it by frequencies
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Put top k frequent elements in the final array
        int[] res = new int[k];
        idx = 0;

        for (int i = n - 1; i >= n - k; i--) {
            res[idx++] = arr[i][1];
        }
        return res;
    }
}

public class kFrequent {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example Test Case
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Finding top k frequent elements
        int[] result = solution.topKFrequent(nums, k);

        // Printing the result
        System.out.println(Arrays.toString(result)); // Output [1, 2]
    }
}

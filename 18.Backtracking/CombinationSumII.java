/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
] */

import java.util.*;

public class CombinationSumII {

    private static  List<List<Integer>> result = new ArrayList<>(); // Resultant list to store combinations

    // Recursive function to find combinations
    public static void solve(int[] nums, int target, int index, List<Integer> list) {
        // Base case: if target is achieved
        if (target == 0) {
            List<Integer> temp = new ArrayList<>();
            for (int j : list) {
                temp.add(j);
            }
            result.add(temp); // Add current combination to result
            return;
        }

        // Base case: if index exceeds array bounds or target is less than current element
        if (index == nums.length || target < nums[index]) {
            return;
        }

        int temp = nums[index];
        list.add(nums[index]); // Choose current element
        solve(nums, target - nums[index], index + 1, list); // Recur with reduced target and move to next index
        list.remove(list.size() - 1); // Backtrack: remove last element

        int i = 1;
        while (index + i < nums.length && nums[index + i] == temp) {
            i++; // Skip duplicates
        }
        solve(nums, target, index + i, list); // Recur without choosing current element
        return;
    }

    // Main function to find combination sum
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort candidates array
        solve(candidates, target, 0, new ArrayList<>()); // Call recursive function
        return result; // Return result
    }

    public static void main(String[] args) {
        int candidates[] = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combinationSum2(candidates,target);

        for (List<Integer> innerList : result) {
            for (Integer num : innerList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

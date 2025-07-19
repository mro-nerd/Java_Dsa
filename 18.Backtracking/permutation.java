/*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] */

import java.util.*;

public class permutation {
    
    static void swapIndices(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void permuteHelper(int[] nums, List<List<Integer>> ans, int i) {
        if (i == nums.length) {
            List<Integer> numList = new ArrayList<>();
            for (int num : nums)
                numList.add(num);
            ans.add(numList);
            return;
        }

        for (int tryId = i; tryId < nums.length; ++tryId) {
            swapIndices(nums, i, tryId);
            permuteHelper(nums, ans, i + 1);
            swapIndices(nums, i, tryId); // backtrack
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteHelper(nums, ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        

        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);

        System.out.println("All permutations:");
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}



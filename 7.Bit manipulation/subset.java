/*Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] */

import java.util.*; 

public class subset {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer> > ans = new ArrayList<>();
        int n = nums.length;

        // iterate over all the bitmasks
        for(int m = 0; m < (1 << n); ++m) {
            List<Integer> curSubset = new ArrayList<>();
            for(int i = 0; i < n; ++i) {
                if(((m >> i) & 1) == 1)
                    curSubset.add(nums[i]);
            }
            ans.add(curSubset);
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[]={5,1,10};
        List<List<Integer>> ans=subsets(arr);
        for(List<Integer> i:ans){
            System.out.println(i);
        }
    }
}
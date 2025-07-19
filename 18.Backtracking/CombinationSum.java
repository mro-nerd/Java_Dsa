/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: [] */

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> output = new ArrayList<>();
        solve(candidates, target, ans, output, 0);
        return ans;
    }

    private void solve(int[] c, int t, List<List<Integer>> ans, List<Integer> output, int index) {
        if (t <= 0) {
            if (t == 0) {
                ans.add(new ArrayList<>(output));
            }
            return;
        }

        for (int i = index; i < c.length; i++) {
            if (c[i] > t) break;
            output.add(c[i]);
            solve(c, t - c[i], ans, output, i);
            output.remove(output.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum obj=new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = obj.combinationSum(candidates, target);
        System.out.println(result);
    }
}

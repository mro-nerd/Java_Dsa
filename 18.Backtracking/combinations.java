/*Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination. */

import java.util.*;

public class combinations {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> subsets = new ArrayList<>();
        solve(1, n, k, subsets);
        return ans;
    }

    private void solve(int begin, int end, int k, List<Integer> subsets) {
        if (subsets.size() == k) {
            ans.add(new ArrayList<>(subsets));
            return;
        }

        for (int i = begin; i <= end; i++) {
            subsets.add(i);
            solve(i + 1, end, k, subsets);
            subsets.remove(subsets.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
       combinations obj = new combinations();

        int n = 4;
        int k = 2;
        List<List<Integer>> combinations = obj.combine(n, k);

        System.out.println("Combinations of " + k + " numbers out of 1 to " + n + ":");
        for (List<Integer> combo : combinations) {
            System.out.println(combo);
        }
    }
}


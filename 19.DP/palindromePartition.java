/*Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut. */

import java.util.Arrays;

public class palindromePartition {
    
    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }

        return dp[0] - 1; // subtract 1 because we count partitions, not cuts
    }

    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="aab";
        int ans=minCut(s);
        System.out.println(ans);
    }
}



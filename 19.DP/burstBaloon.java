/*You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 */

import java.util.ArrayList;
import java.util.Arrays;

public class burstBaloon {
    static int maxCoins(ArrayList<Integer> a) {
        int n = a.size();
        
        // Add 1 to the beginning and end of the array
        a.add(0, 1);
        a.add(1);
        
        // Create a 2D DP array
        int[][] dp = new int[n + 2][n + 2];

        // Iterate from the end to the beginning
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int maxi = Integer.MIN_VALUE;
                
                // Iterate through possible indices to split the array
                for (int ind = i; ind <= j; ind++) {
                    int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1) +
                               dp[i][ind - 1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 1, 5, 8));
        int ans = maxCoins(a);
        System.out.println(ans);
    }
}

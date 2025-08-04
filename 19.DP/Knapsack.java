/*There are N items, numbered 1,2,…,N. For each i (1≤i≤N), Item i has a weight of w i​  and a value of v i.
Taro has decided to choose some of the N items and carry them home in a knapsack. The capacity of the knapsack is W, which means that the sum of the weights of items taken must be at most W.

Find the maximum possible sum of the values of items that Taro takes home.
Input is like 
N  W
w1 v1
w2 v2
.  .
.  .
.  .
.  .

Example:
Input:
3 8
3 30
4 50
5 60
Output:
90
*/

import java.util.*;

public class Knapsack {
    public static void main(String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        long[][] dp = new long[n + 1][W + 1];

        // Bottom-up DP
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (w[i - 1] <= j) {
                    // Take the item or don't take
                    dp[i][j] = Math.max(dp[i - 1][j], v[i - 1] + dp[i - 1][j - w[i - 1]]);
                } else {
                    // Can't take the item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][W]);
    }
}

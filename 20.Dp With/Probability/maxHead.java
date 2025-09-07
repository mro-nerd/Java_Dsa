/*Let N be a positive odd number.There are N coins, numbered 1,2,…,N. For each i (1≤i≤N), when Coin i is tossed, it comes up heads with probability pi and tails with probability 1−pi
​
Taro has tossed all the N coins. Find the probability of having more heads than tails.

Constraints
->N is an odd number.
->1≤N≤2999
->pi is a real number and has two decimal places.
->0<p i <1 */

import java.util.*;

public class maxHead {
    static double dp[][];
    static double p[];

    static double probHelper(int n, int h) {
        if(n == 0 && h > 0)
            return 0.0;
        if(n == 0 && h == 0)
            return 1.0;
        if(dp[n][h] != -1.0)
            return dp[n][h];
        
        // Last throw gets us tails.
        double pt = 1.0 - p[n];

        // Last throw gets us heads.
        double ph = p[n];

        if(h == 0)
            return dp[n][h] = pt * probHelper(n-1,h);

        return dp[n][h] = pt * probHelper(n-1,h) + ph * probHelper(n-1, h-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        p = new double[n+1];
        dp = new double[n+1][n+1];
        for(double row[] : dp)
            Arrays.fill(row, -1.0);

        for(int i = 1; i <= n; ++i)
            p[i] = sc.nextDouble();

        double ans = 0.0;

        for(int h = n/2 + 1; h <= n; ++h) {
            ans += probHelper(n, h);
        }

        System.out.println(ans);
    }
}
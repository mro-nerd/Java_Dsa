/*We have to travel for N days and there are N cities to travel,On each day we can travel to 1 city only  or stay at same city. On each ith day there is certain reward points for every jth city given in arrays rew[i][j], calculate the max reward that traveler can collect in N days when to travel from anyone city to anyother city, C points are deducted each time from your collected reward points.

Ex:-
Input:
N=5
C=10
rew[][]=
1 5 1 4 2
5 1 4 2 10
1 1 1 1 1 
2 2 2 2 2
3 1 3 4 0

Output:15 */

import java.util.Scanner;

public class maxReward2 {
     static int maxRewards(int rew[][], int n, int c) {
        int dp[][] = new int[n][n];
        int lastMax = Integer.MIN_VALUE, lastSecMax = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; ++i) {
            int curMax = Integer.MIN_VALUE, curSecMax = Integer.MIN_VALUE;
            for(int j = 0; j < n; ++j) {
                if(i == 0)
                    dp[i][j] = rew[i][j];
                else {
                    int bestDP = dp[i-1][j] == lastMax? lastSecMax : lastMax;
                    dp[i][j] = rew[i][j] + Math.max(dp[i-1][j], bestDP - c);
                }
                if(dp[i][j] >= curMax) {
                    curSecMax = curMax;
                    curMax = dp[i][j];
                }
                else if(dp[i][j] >= curSecMax)
                    curSecMax = dp[i][j];
            }
            lastMax = curMax;
            lastSecMax = curSecMax;
        }

        int ans = 0;
        for(int j = 0; j < n; ++j)
            ans = Math.max(ans, dp[n-1][j]);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int rew[][] = new int[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                rew[i][j] = sc.nextInt();
        System.out.println(maxRewards(rew, n, c));
        sc.close();
    }
}

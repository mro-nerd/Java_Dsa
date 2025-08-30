/*We have to travel for N days and there are N cities to travel,On each day we can travel to 1 city only  or stay at same city. On each ith day there is certain reward points for every jth city given in arrays rew[i][j], calculate the max reward that traveler can collect in N days when to travel from anyone city to anyother city, abs(j1-j2) points are deducted each time from your collected reward points(j1 is prev visited city on i-1th day and j2 is city visited on ith day ).

Ex:-
Input:
N=5
rew[][]=
1 5 1 4 2
5 1 4 2 10
1 1 1 1 1 
2 2 2 2 2
3 1 3 4 0

Output:19 */


import java.util.Scanner;

public class maxReward3 {
    static int maxRewards(int rew[][], int n) {
        int dp[][] = new int[n][n];
        int pre[][] = new int[n][n];
        int suf[][] = new int[n][n];
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i == 0)
                    dp[i][j] = rew[i][j];
                else {
                    int comingFromLeft = rew[i][j] - j + pre[i-1][j]; // dp[i-1][k] + k (k <= j);
                    int comingFromRight = rew[i][j] + j + suf[i-1][j]; // dp[i-1][k] - k (k >= j);
                    dp[i][j] = Math.max(comingFromLeft, comingFromRight);
                }
                pre[i][j] = j == 0? dp[i][j] + j : Math.max(pre[i][j-1], dp[i][j] + j);
            }
            for(int j = n - 1; j >= 0; --j) {
                suf[i][j] = j == n-1? dp[i][j] - j : Math.max(suf[i][j+1], dp[i][j] - j);
            }
        }

        int ans = 0;
        for(int j = 0; j < n; ++j)
            ans = Math.max(ans, dp[n-1][j]);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rew[][] = new int[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                rew[i][j] = sc.nextInt();
        System.out.println(maxRewards(rew, n));
        sc.close();
    }
}

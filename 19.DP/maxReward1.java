/*We have to travel for N days and there are N cities to travel,On each day we can travel to 1 city only  or stay at same city. On each ith day there is certain reward points for every jth city given in arrays rew[i][j], calculate the max reward that traveler can collect in N days.

Ex:-
Input:
N=5
rew[][]=
1 5 1 4 2
5 1 4 2 10
1 1 1 1 1 
2 2 2 2 2
3 1 3 4 0

Output:22
*/

import java.util.Scanner;

public class maxReward1 {
     static int maxRewards(int rew[][], int n) {
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            int bestReward = 0;
            for(int j = 0; j < n; ++j)
                bestReward = Math.max(bestReward, rew[i][j]);
            ans += bestReward;
        }
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

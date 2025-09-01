/*Given an array arr from [0....n-1] and an array rew[i][j] where i is element of arr[] and j is its position in arr[]. You have to rearrange array such that total reward points from rew[][] is max

Example:-
Input: n=3
       rew[][]=[[1,2,3],[6,5,4],[7,8,9]]

Output: 17

Explaination: if we amke our array like [1,2,0] then total reward will be rew[0][2]+rew[1][0]+rew[2][1]=3+6+8=17.
 */

import java.util.*;

public class permutationReward {
    static int setBits(int m) {
        int ans = 0;
        while(m > 0) {
            ans++;
            m &= (m-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // [0, 1, 2, ..... n - 1];

        int rew[][] = new int[n][n];
        
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                rew[i][j] = sc.nextInt();
        
        int dp[] = new int[1<<n];

        for(int m = 1; m < (1<<n); ++m) {
            int id = setBits(m) - 1;
            for(int i = 0; i < n; ++i) {
                if(((m>>i)&1) > 0) {
                    int curRew = rew[i][id];
                    int furtherRew = dp[m ^ (1<<i)];
                    dp[m] = Math.max(dp[m], curRew + furtherRew);
                }
            }
        }

        System.out.println(dp[(1<<n) - 1]);
    }
}
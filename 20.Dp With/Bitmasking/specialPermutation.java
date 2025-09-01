/*You are given a 0-indexed integer array nums containing n distinct positive integers. A permutation of nums is called special if:

For all indexes 0 <= i < n - 1, either nums[i] % nums[i+1] == 0 or nums[i+1] % nums[i] == 0.
Return the total number of special permutations. As the answer could be large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [2,3,6]
Output: 2
Explanation: [3,6,2] and [2,6,3] are the two special permutations of nums.
Example 2:

Input: nums = [1,4,3]
Output: 2
Explanation: [3,1,4] and [4,1,3] are the two special permutations of nums.
 

Constraints:

2 <= nums.length <= 14
1 <= nums[i] <= 109 */

public class specialPermutation {
    static int MOD = (int)1e9 + 7;
    static int N;
    static Integer[][] dp;
    static int[] nums={2,3,6};
    public static void main(String[] args) {
        N = nums.length;
        dp = new Integer[N][1 << N];
        
        int ans= rec(0, 0);
        System.out.println(ans);
    }

    static int rec(int preIndex, int mask) {
        if (mask == (1 << N) - 1) return 1;//if all no. are used even after checking all the condition then this means that we have 1 valid arrangement
        if (dp[preIndex][mask] != null) return dp[preIndex][mask];
        int count = 0;
        for (int i = 0; i < N; i++)
            if ((mask & (1 << i)) == 0 && 
                (mask == 0 || nums[i] % nums[preIndex] == 0 || nums[preIndex] % nums[i] == 0))
                count = (count + rec(i, mask | (1 << i))) % MOD;//given in question to return the mod of ans
        return dp[preIndex][mask] = count;
    }
    
} 
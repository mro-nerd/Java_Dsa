/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4. */

public class houseRob {
    public static int rob(int[] nums) {
        // dp[n] represents answer for the first
        // n elements i.e. index range [0, n - 1]
        int dp[] = new int[nums.length+1];

        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for(int n = 3; n <= nums.length; ++n) {

            // Let nums[n-1] be our last chosen house
            int poss1 = nums[n-1] + dp[n-2];

            // Let nums[n-2] be our last chosen house
            int poss2 = nums[n-2] + dp[n-3];

            dp[n] = Math.max(poss1, poss2);
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {
        int a[]={5,4,6,100};
        int ans= rob(a);
        System.out.println(ans);
    }

    
}

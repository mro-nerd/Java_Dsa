/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses. */


public class houseRobberII {

    public static int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        return Math.max(helper(nums,0,n-2),helper(nums,1,n-1));
    }
    public static int helper(int[]nums,int st,int end){
        int prev2 = 0;
        int prev1 = 0;

        for (int i = st; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        int ans = rob(nums);
        System.out.println(ans);
    }
}

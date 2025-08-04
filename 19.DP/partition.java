/*Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11]. */

public class partition {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base Case: sum = 0 is always possible (by picking nothing)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int t = 1; t <= target; t++) {
                // Not take current number
                boolean notTake = dp[i - 1][t];

                // Take current number (only if it's <= current target)
                boolean take = false;
                if (nums[i - 1] <= t) {
                    take = dp[i - 1][t - nums[i - 1]];
                }

                dp[i][t] = take || notTake;
            }
        }

        return dp[n][target];
    }
    public static void main(String[] args) {
        int nums[]={1,5,11,5};
        boolean ans= canPartition(nums);
        System.out.println(ans);
    }
}

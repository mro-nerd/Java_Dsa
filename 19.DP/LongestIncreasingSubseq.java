/*Given an integer array nums, return the length of the longest strictly increasing subsequence.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. */

 /*VIA DP 
public class LongestIncreasingSubseq {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 0;
        int dp[] = new int[n];
        for(int i = 0; i < n; ++i) {
            dp[i] = 1; // because, in the worst case, arr[i] alone can be a subsequence.
            for(int j = 0; j < i; ++j)
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            // Take max of all dp values
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={10,9,2,5,3,7,108,18};
        int ans=lengthOfLIS(nums);
        System.out.println(ans);
    }
}/* */

import java.util.*;

class LongestIncreasingSubseq {


    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > lis.get(lis.size() - 1)) {
                lis.add(nums[i]);
            } else {
                // Binary search to find the first element >= nums[i]
                int index = Collections.binarySearch(lis, nums[i]);

                // If not found, binarySearch returns (-(insertion_point) - 1)
                if (index < 0) {
                    index = -(index + 1);
                }

                lis.set(index, nums[i]);
            }
        }
        for(Integer i:lis){
            System.out.println(i);
        }
        return lis.size();
    }

    public static void main(String[] args) {
        int nums[] = {3,10,2,1,20};
        int ans = lengthOfLIS(nums);
        System.out.println(ans);
    }
}


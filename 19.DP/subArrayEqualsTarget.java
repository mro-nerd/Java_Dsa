/*You are given an array of integers arr and an integer target.You have to find two non-overlapping sub-arrays of arr each with a sum equal target. There can be multiple answers so you have to find an answer where the sum of the lengths of the two sub-arrays is minimum.

Return the minimum sum of the lengths of the two required sub-arrays, or return -1 if you cannot find such two sub-arrays.

Example 1:

Input: arr = [3,2,2,4,3], target = 3
Output: 2
Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2. */

import java.util.*;

public class subArrayEqualsTarget {
    public static int minSumOfLengths(int[] arr, int target) {
        
        int[] dp = new int[arr.length]; //dp[i] := length of smallest subarray in range arr[0]...arr[i] with sum = target
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        int res = Integer.MAX_VALUE;
        
        //sliding window
        int sum = 0; //sum of current window
        int l = 0;
        for(int r = 0; r < arr.length; r++) {
            
            //invite new element into RHS
            sum+=arr[r];
    
            //contract until valid
            while(l <= r && sum>target){
                sum-=arr[l];
                l++;
            }
            
            //if valid, process
            if(sum==target) {
                
                //current window arr[l]...a[r]
                int lenCurr = r - l + 1;
                
                //want best from prev iterations, dp[l-1]
                int prevBest = (l==0) ? Integer.MAX_VALUE : dp[l-1];
                
                //process res
                if(prevBest != Integer.MAX_VALUE) {
                    res = Math.min(res, lenCurr+prevBest);
                }
                
                //now process dp 
                dp[r] = (r==0) ? lenCurr : Math.min(lenCurr, dp[r-1]);
            }
            else {
                //else not valid, inherit dp[prev iteration]
                dp[r] = (r==0) ? Integer.MAX_VALUE : dp[r-1];
            }
        }
        
        return (res==Integer.MAX_VALUE) ? -1 : res;
    }
    public static void main(String[] args) {
        int[] arr= {3,2,2,4,3};
        int target=3;
        int ans=minSumOfLengths(arr, target);
        System.out.println(ans);
    }
}
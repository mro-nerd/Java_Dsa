/*You are given two integer arrays nums1 and nums2 of length n.
The XOR sum of the two integer arrays is (nums1[0] XOR nums2[0]) + (nums1[1] XOR nums2[1]) + ... + (nums1[n - 1] XOR nums2[n - 1]) (0-indexed).

For example, the XOR sum of [1,2,3] and [3,2,1] is equal to (1 XOR 3) + (2 XOR 2) + (3 XOR 1) = 2 + 0 + 2 = 4.
Rearrange the elements of nums2 such that the resulting XOR sum is minimized.

Return the XOR sum after the rearrangement.

Example 1:

Input: nums1 = [1,2], nums2 = [2,3]
Output: 2
Explanation: Rearrange nums2 so that it becomes [3,2].
The XOR sum is (1 XOR 3) + (2 XOR 2) = 2 + 0 = 2. */

import java.util.*;

public class minXOR {
    public static int rec(int[] A, int[] B, int[] dp, int i, int mask) {
        if (i == A.length)
            return 0;
        if (dp[mask] != Integer.MAX_VALUE)
            return dp[mask];

        for (int j = 0; j < B.length; ++j) {
            if ((mask & (1 << j)) == 0) {
                dp[mask] = Math.min(dp[mask], (A[i] ^ B[j]) +
                                                rec(A, B, dp, i + 1, mask | (1 << j)));
            }
        }

        return dp[mask];
    }

    public static void main(String[] args) {
        int nums1[]={1,0,3};
        int nums2[]={5,3,4};
        int[] dp = new int[1 << nums2.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans= rec(nums1, nums2, dp, 0, 0);
        System.out.println(ans);
    }

}

/*Given an integer array nums and an integer k, return the number of subarrays of nums where the least common multiple of the subarray's elements is k.

Example 1:

Input: nums = [3,6,2,7,1], k = 6
Output: 4
Explanation: The subarrays of nums where 6 is the least common multiple of all the subarray's elements are:
- [(3,6),2,7,1]
- [3,(6),2,7,1]
- [3,(6,2),7,1]
- [(3,6,2),7,1] */

import java.util.Scanner;

class Solution {

    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int curLCM = nums[i];
            if (curLCM == k) {
                ans++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                curLCM = lcm(nums[j], curLCM);
                if (curLCM == k) {
                    ans++;
                }
                if (nums[j] > k) {
                    break;
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}

public class subarrayLcmK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter value of k: ");
        int k = scanner.nextInt();
        scanner.close();

        Solution solution = new Solution();
        int result = solution.subarrayLCM(nums, k);

        System.out.println("Number of subarrays with LCM equal to " + k + ": " + result);

        scanner.close();
    }
}

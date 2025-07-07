/*Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
Since the result may be very large, so you need to return a string instead of an integer.

Example:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"*/

import java.util.*;

public class largestNumber {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.largestNumber(nums));
        scanner.close();
    }
}

class Solution {
    private static class NumComparator implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            String s = Integer.toString(x);
            String t = Integer.toString(y);
            if ((s + t).compareTo(t + s) > 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public String largestNumber(int[] nums) {
        Integer[] numObjects = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numObjects[i] = nums[i];
        }
        Arrays.sort(numObjects, new NumComparator());
        StringBuilder sb = new StringBuilder();
        for (int num : numObjects) {
            sb.append(num);
        }
        String ans = sb.toString();
        if (ans.charAt(0) == '0') {
            return "0";
        }
        return ans;
    }
}

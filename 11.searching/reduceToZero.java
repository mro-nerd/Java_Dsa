/*You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1. 

ex:
Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
*/

public class reduceToZero {
    public static void main(String[] args) {
        int nums[]={3,2,20,1,1,3};
        int x=10;
        System.out.println(minOperations(nums, x));

    }
    public static  int minOperations(int[] nums, int x) {
        int sum = 0, n = nums.length;
        for (int i : nums) {
            sum += i;
        }
        int target = sum - x;
        int currSum = 0, maxLen = 0;
        int startIdx = 0;
        boolean found = false;

        for (int endIdx = 0; endIdx < n; endIdx++) {
            currSum += nums[endIdx];
            while (startIdx <= endIdx && currSum > target) {
                currSum -= nums[startIdx];
                startIdx += 1;
            }
            if (currSum == target) {
                found = true;
                maxLen = Math.max(maxLen, endIdx - startIdx + 1);
            }
        }
        return found ? n - maxLen : -1;
    }
}

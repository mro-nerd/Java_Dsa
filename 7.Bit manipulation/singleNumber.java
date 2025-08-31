/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1 */

public class singleNumber {
    public static void main(String[]args){
        int ans = 0;
        int nums[]={4,1,2,1,2};
        for(int num : nums)
            ans ^= num;
        System.out.println(ans);
    }
}
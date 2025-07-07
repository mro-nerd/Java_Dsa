/*You are given an integer array nums and an integer k.
In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. You can apply this operation at most once for each index i.
The score of nums is the difference between the maximum and minimum elements in nums.
Return the minimum score of nums after applying the mentioned operation at most once for each index in it. */


public class smallestRange{
    public static void main(String[] args){
        int nums[]={1,3,6};
        int k=3;
        System.out.println(smallestRangeI(nums, k));


    }
    public static int smallestRangeI(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (max - min <= 2 * k) {
            return 0;//when all elements can be turned to equal
        } else {
            return max - min - 2 * k;
        }

    }
}
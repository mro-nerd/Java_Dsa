/*You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
0 <= j <= nums[i] and i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1]. */

public class jumpGame {
   public static int ans = 0; // Variable to keep track of the number of jumps
    public static void main(String[] args){
        int nums[]={2,3,1,1,4};
        System.out.println(jump(nums));
        
    }
    

    public static  int jump(int[] nums) {
        int i = 0; // Start from the first index
        // Continue jumping until the last index is reached or exceeded
        while (i < nums.length - 1) {
            i = helper(i, nums[i], nums); // Find the next position to jump to
        }
        return ans; // Return the total number of jumps
    }

    // Helper function to determine the best next jump
    public static int helper(int a, int b, int[] nums) {
        ans++; // Increment the jump counter
        // If the current jump can reach or exceed the last index, return an index
        // beyond the last index
        if (a + b >= nums.length - 1) {
            return nums.length;
        }
        int max = Integer.MIN_VALUE; // Variable to track the maximum reach
        int temp = 0; // Variable to store the index of the best next position to jump to
        // Iterate through all possible positions that can be reached from the current
        // position
        for (int i = a; i <= a + b; i++) {
            // Update max and temp if a better position is found
            if (nums[i] + i >= max) {
                temp = i;
                max = nums[i] + i;
            }
        }
        return temp; // Return the best next position to jump to
    }
}

/* Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

ex:Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]*/

import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        // Initialize answer array with -1 (default case if no NGE is found)
        Arrays.fill(ans, -1);

        // Traverse the array twice to simulate the circular nature
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Maintain decreasing order in stack
            while (!st.isEmpty() && st.peek() <= nums[i % n]) //i%n deals with virtual elements after n
             {
                st.pop();
            }

            // Assign the next greater element in ans[] only for the first n elements not for virtual elements.
            if (i < n) {
                if (!st.isEmpty()) {
                    ans[i] = st.peek();
                }
            }

            // Push current element into stack (considered for next elements)
            st.push(nums[i % n]);
        }
        return ans;
    }
}

// Driver Code
public class NgeII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 3};
        int[] result = solution.nextGreaterElements(nums);
        
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}



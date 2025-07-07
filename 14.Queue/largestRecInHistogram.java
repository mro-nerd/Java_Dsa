/*Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

eg: Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
 */

import java.util.*;

class Solution {
    int[] prevSmaller(int[] arr) {//opposite of stock span
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; ++i) {
            while(!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            ans[i] = s.empty()? -1 : s.peek();
            s.push(i);
        }
        return ans;
    }
    int[] nextSmaller(int[] arr) {//opposite of NGE
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = n - 1; i >= 0; --i) {
            while(!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            ans[i] = s.empty()? n : s.peek();
            s.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[] next = nextSmaller(heights);
        int[] prev = prevSmaller(heights);

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; ++i) 
            ans = Math.max(ans, (next[i] - prev[i] - 1)*heights[i]);
        return ans;
    }
}

public class largestRecInHistogram {
    public static void main(String[] args) {
        
        Solution solution = new Solution();
        
    
        int[] heights = {2, 1, 5, 6, 2, 3};
        
    
        int largestArea = solution.largestRectangleArea(heights);
        System.out.println("The largest rectangle area is: " + largestArea);
    }
}

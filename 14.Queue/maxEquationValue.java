/*You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.

Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.

It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.

 

Example 1:

Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
Output: 4
Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
No other pairs satisfy the condition, so we return the max of 4 and 1.
Example 2:

Input: points = [[0,0],[3,0],[9,2]], k = 3
Output: 3
Explanation: Only the first two points have an absolute difference of 3 or less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3. */


import java.util.*;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int finalAns = Integer.MIN_VALUE;
        // Iterate on all j values.
        for(int j = 0; j < points.length; ++j) {
            // Pop the ones that are invalid
            // now & have gone out of the window
            while(!q.isEmpty() && points[q.peekFirst()][0] < points[j][0] - k)
                q.removeFirst();

            // If there is a valid i left
            if(!q.isEmpty()) {
                int i = q.peekFirst();
                int curAns = points[i][1] + points[j][1] + points[j][0] - points[i][0];
                finalAns = Math.max(finalAns, curAns);
            }

            // Adding afterwards because
            // i < j, and not i <= j
            int y_minus_x = points[j][1] - points[j][0];
            while(!q.isEmpty() && points[q.peekLast()][1] - points[q.peekLast()][0] <= y_minus_x)
                q.removeLast();
            // then push the current index.
            q.addLast(j);
        }
        return finalAns;
    }
}

public class maxEquationValue {    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Define a test case
        int[][] points = {{1, 3}, {2, 0}, {3, 10}, {4, 5}, {5, 3}};
        int k = 2;
        
        // Call the findMaxValueOfEquation function and print the result
        int result = solution.findMaxValueOfEquation(points, k);
        System.out.println("The maximum value of the equation is: " + result);
    }
}



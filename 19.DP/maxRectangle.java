/*Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1: 
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
*/

import java.util.*;

public class maxRectangle {
    static int[] prevSmaller(int[] arr) {
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
    static int[] nextSmaller(int[] arr) {
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
    public static int findLargestAreaInHistogram(int[] heights) {
        int[] next = nextSmaller(heights);
        int[] prev = prevSmaller(heights);

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; ++i) 
            ans = Math.max(ans, (next[i] - prev[i] - 1)*heights[i]);
        return ans;
    }
    public static  int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int area = 0;
        
        // First, make the histogram row-wise
        int[] rowHistogram = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == '1') {
                    rowHistogram[j]++;
                } else {
                    rowHistogram[j] = 0;
                }
            }
            // Now I have created the histogram for the particular level
            // Now find the largest area in that level
            area = Math.max(area, findLargestAreaInHistogram(rowHistogram));
        }
        return area;
    }
    public static void main(String[] args) {
        char matrix[][]={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int ans=maximalRectangle(matrix);
        System.out.println(ans);
    }
}

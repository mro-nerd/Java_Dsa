/*You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Exampl 1:

Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]

Example 2:

Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]

 */

import java.util.*;

public class reshapeMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        Solution obj = new Solution();
        int[][] ans = obj.matrixReshape(mat, r, c);
        for (int[] row : ans) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (n * m != r * c) return mat;
        int[][] ans = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int flattenedIdx = i * n + j;
                int newRow = flattenedIdx / c;
                int newCol = flattenedIdx % c;
                ans[newRow][newCol] = mat[i][j];
            }
        }
        return ans;
    }
}

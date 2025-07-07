// # Given a 2D matrix matrix, handle multiple queries of the following type:
//Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

public class NumMatrix {
    private int[][] pre_arr = new int[200][200];

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {//creating 2D prefix sum array
                    pre_arr[i][j] = matrix[i][j];
                } else if (i == 0) {
                    pre_arr[i][j] = pre_arr[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    pre_arr[i][j] = pre_arr[i - 1][j] + matrix[i][j];
                } else {
                    pre_arr[i][j] = matrix[i][j] + pre_arr[i - 1][j] + pre_arr[i][j - 1] - pre_arr[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = pre_arr[row2][col2];    //calculating sum according to the given query
        if (row1 > 0) {
            ans -= pre_arr[row1 - 1][col2];
        }
        if (col1 > 0) {
            ans -= pre_arr[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            ans += pre_arr[row1 - 1][col1 - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };

        NumMatrix obj = new NumMatrix(matrix);
        int param_1 = obj.sumRegion(2, 1, 4, 3);
        System.out.println(param_1); // Output should be 8
    }
}

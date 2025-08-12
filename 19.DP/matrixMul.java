/*Given an array arr[] which represents the dimensions of a sequence of matrices where the ith matrix has the dimensions (arr[i-1] x arr[i]) for i>=1, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.

Examples:

Input: arr[] = [2, 1, 3, 4]
Output: 20
Explanation: There are 3 matrices of dimensions 2 × 1, 1 × 3, and 3 × 4, Let this 3 input matrices be M1, M2, and M3. There are two ways to multiply: ((M1 x M2) x M3) and (M1 x (M2 x M3)), note that the result of (M1 x M2) is a 2 x 3 matrix and result of (M2 x M3) is a 1 x 4 matrix. 
((M1 x M2) x M3)  requires (2 x 1 x 3) + (2 x 3 x 4) = 30 
(M1 x (M2 x M3))  requires (1 x 3 x 4) + (2 x 1 x 4) = 20. 
The minimum of these two is 20. */

public class matrixMul {
     public static int matrixMultiplication(int N, int[] arr) {
        int[][] dp = new int[N][N];

        // dp[i][j] will hold the minimum number of multiplications needed to multiply matrices from i to j

        for (int i = N - 1; i >= 1; i--) {
            for (int j = i + 1; j < N; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = arr[i - 1] * arr[k] * arr[j] 
                             + dp[i][k] 
                             + dp[k + 1][j];

                    min = Math.min(min, cost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][N - 1]; // final answer: cost to multiply matrices from 1 to N-1
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int N = arr.length;

        System.out.println("Minimum number of multiplications: " + matrixMultiplication(N, arr));
    }
}

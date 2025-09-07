/*We have N buckets (1 through N).Each bucket has some balls, and each ball has one of colors between 1 to k.
Process:

From bucket 1 to N−1 → pick one ball randomly from bucket i and move it to bucket i+1.
Finally, from bucket N → pick one ball randomly.

Task: For each color j (1 to K), find the probability that the final chosen ball is of color j, i.e find the probability of each color ball(1->k) that it is the final ball drwan from nth bucket.

Ex;
Input: 2  2 // N K
       0  1 //shows that in 1st bucket 1 color ball is 0 in number and 2 color ball is 1 in number
       1  1 //shows that in 2nd bucket 1 color ball is 1 in number and 2 color ball is 1 in number 
       
Outpu: 0.33 0.66
Explaination: if in first there is only 2 color ball so we can only pick it and put in 2nd bucket now bucket 2 has 2 color 2 balls and 1 color 1 ball so now when we will draw ball then the probability that it is of color 1 is 1/3 or    0.33 and of color 2 is 2/3 or 0.66*/

import java.util.Scanner;

public class bucket {

    // Function to solve the problem
    static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of buckets
        int k = scanner.nextInt(); // number of colors
        int[][] v = new int[n][k]; // array to store colors in each bucket

        // Inputting the colors in each bucket
        for (int i = 0; i < n; i++)
            for (int j = 0; j < k; j++)
                v[i][j] = scanner.nextInt();

        // 2D array to store DP states
        double[][] dp = new double[n][k];

        // Initializing base case for bucket 0
        int d = 0;
        for (int j = 0; j < k; j++) d += v[0][j]; // calculating the sum of colors in bucket 0
        for (int j = 0; j < k; j++) dp[0][j] = (1.0 * v[0][j]) / d; // setting probabilities for bucket 0

        // Filling up the DP table
        for (int i = 1; i < n; i++) {
            d = 0;
            for (int j = 0; j < k; j++) d += v[i][j]; // calculating the sum of colors in bucket i
            for (int j = 0; j < k; j++) {
                // Transition formula
                dp[i][j] = ((1.0 * dp[i - 1][j]) * ((1.0 * (v[i][j] + 1)) / (d + 1))) +
                        ((1.0 * (1 - dp[i - 1][j])) * ((1.0 * v[i][j]) / (d + 1)));
            }
        }

        // Printing the final answers
        for (int i = 0; i < k; i++) {
            System.out.printf("%.12f ", dp[n - 1][i]); // formatting output to 12 decimal places
        }
    }

    public static void main(String[] args) {
        solve();
    }
}

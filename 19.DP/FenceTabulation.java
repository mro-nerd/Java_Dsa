/*You have a fence consisting of n vertical boards.Each board has a width of 1.The height of the i-th board is aᵢ.You consider the fence great if no two adjacent boards have the same height. Formally, for all indices i from 2 to n, the condition aᵢ ≠ aᵢ₋₁ must hold.

Unfortunately, your fence might not be great. But you can fix it!You are allowed to increase the height of the i-th board by 1 unit, but it costs bᵢ rubles. You can increase the height of each board any number of times (including zero).

Your task is to calculate the minimum number of rubles you need to spend to make the fence great.You have to answer q independent queries.

Input Format
The first line contains a single integer q — the number of queries. (1 ≤ q ≤ 3 × 10⁵)
Each query is described as follows:
The first line contains a single integer n — the number of boards in the fence. (1 ≤ n ≤ 3 × 10⁵)
The next n lines describe the boards. Each line contains two integers aᵢ and bᵢ — the initial height and cost to increase the height of the i-th board by 1. (1 ≤ aᵢ, bᵢ ≤ 10⁹)

Output Format
For each query, print a single integer — the minimum number of rubles required to make the fence great.

Constraints
The sum of all n over all queries does not exceed 3 × 10⁵.
The answer to each query will not exceed 10¹⁸. */

import java.io.*;
import java.util.*;

public final class FenceTabulation {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(r.readLine());

            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; ++i) {
                String[] line = r.readLine().split(" ");
                a[i] = Integer.parseInt(line[0]);
                b[i] = Integer.parseInt(line[1]);
            }

            long[][] dp = new long[n][3];
            // initialize with large value
            for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);

            // base case: first board
            for (int j = 0; j <= 2; j++) {
                dp[0][j] = (long) j * b[0];
            }

            // fill table
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= 2; j++) {
                    long cost = (long) j * b[i];
                    for (int k = 0; k <= 2; k++) {
                        if (a[i - 1] + k != a[i] + j) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + cost);
                        }
                    }
                }
            }

            // answer is min over last row
            long ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));

            w.println(ans);
        }

        w.flush();
        w.close();
        r.close();
    }
}

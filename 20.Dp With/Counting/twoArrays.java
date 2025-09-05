/*You are given two integers n and m. Calculate the number of pairs of arrays (a,b) such that:
the length of both arrays is equal to m.Each element of each array is an integer between 1 and n (inclusive) and ai≤bi for any index i from 1 to m.Array a is sorted in non-descending order, Array b is sorted in non-ascending order.As the result can be very large, you should print it modulo 109+7.

Input
The only line contains two integers n and m (1≤n≤1000, 1≤m≤10).

Output
Print one integer – the number of arrays a and b satisfying the conditions described above modulo 109+7. */

import java.util.*;

public class twoArrays {
    static final int MAXM = 1005;   // same as 1e3+5
    static final int MOD = 1000000007;
    static long[][] d = new long[25][MAXM]; // d[i][j]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // base case: length = 1
        for (int i = 1; i <= n; i++) {
            d[1][i] = 1;
        }

        m *= 2; // doubling length as in your logic

        for (int i = 2; i <= m; i++) { // non-decreasing arrays
            for (int j = 1; j <= n; j++) {
                d[i][j] = d[i][j - 1] + d[i - 1][j];
                if (d[i][j] >= MOD) d[i][j] -= MOD; // keep within mod
            }
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += d[m][i];
            if (ans >= MOD) ans -= MOD;
        }

        System.out.println(ans);
    }
}

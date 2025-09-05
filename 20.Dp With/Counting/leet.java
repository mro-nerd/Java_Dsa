/*You are given an integer n.A string s is called good if it contains only lowercase English characters and it is possible to rearrange the characters of s such that the new string contains "leet" as a substring.

For example:

The string "lteer" is good because we can rearrange it to form "leetr" .
"letl" is not good because we cannot rearrange it to contain "leet" as a substring.
Return the total number of good strings of length n.

Since the answer may be large, return it modulo 109 + 7.

Example 1:

Input: n = 4
Output: 12
Explanation: The 12 strings which can be rearranged to have "leet" as a substring are: "eelt", "eetl", "elet", "elte", "etel", "etle", "leet", "lete", "ltee", "teel", "tele", and "tlee".
Example 2:

Input: n = 10
Output: 83943898
Explanation: The number of strings with length 10 which can be rearranged to have "leet" as a substring is 526083947580. Hence the answer is 526083947580 % (109 + 7) = 83943898. */

public class leet {
    static int mod = 1000000007;
    static int[][][][] dp;

    public static void main(String[] args) {
        int n=10;
        dp = new int[n + 1][2][3][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 2; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        int a = fun(0, n, 0, 0, 0) % mod;
        System.err.println(a);
    }

    public static int fun(int i, int n, int l, int e, int t) {
    if (i == n) {
        if (l == 1 && e >= 2 && t == 1) return 1;
        return 0;
    }
    if (dp[i][l][e][t] != -1) return dp[i][l][e][t];

    int res = fun(i + 1, n, l, e, t) % mod;
    res = (int) (((long) res * 23) % mod);
    res = (res + fun(i + 1, n, Math.min(l + 1, 1), e, t) % mod) % mod;
    res = (res + fun(i + 1, n, l, Math.min(e + 1, 2), t) % mod) % mod;
    res = (res + fun(i + 1, n, l, e, Math.min(t + 1, 1)) % mod) % mod;

    return dp[i][l][e][t] = res;
}

}

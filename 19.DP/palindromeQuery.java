/* You've got a string s = s1s2... s|s| of length |s|, consisting of lowercase English letters. There also are q queries, each query is described by two integers li, ri (1 ≤ li ≤ ri ≤ |s|). The answer to the query is the number of substrings of string s[li... ri], which are palindromes.

String s[l... r] = slsl + 1... sr (1 ≤ l ≤ r ≤ |s|) is a substring of string s = s1s2... s|s|.

String t is called a palindrome, if it reads the same from left to right and from right to left. Formally, if t = t1t2... t|t| = t|t|t|t| - 1... t1.

Input
The first line contains string s (1 ≤ |s| ≤ 5000). The second line contains a single integer q (1 ≤ q ≤ 106) — the number of queries. Next q lines contain the queries. The i-th of these lines contains two space-separated integers li, ri (1 ≤ li ≤ ri ≤ |s|) — the description of the i-th query.

It is guaranteed that the given string consists only of lowercase English letters.

Output
Print q integers — the answers to the queries. Print the answers in the order, in which the queries are given in the input. Separate the printed numbers by whitespaces.*/

import java.io.*;

public class palindromeQuery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = reader.readLine();
        int q = Integer.parseInt(reader.readLine());
        int n = s.length();
        int[][] dp = new int[n][n];
        boolean[][] ispal = new boolean[n][n];

        // Calculate if the substring from `st` to `end` is a palindrome or not.
        for (int i = 0; i < n; i++) {
            // Odd length
            int st = i, end = i;
            while (st >= 0 && end < n && s.charAt(st) == s.charAt(end)) {
                ispal[st][end] = true;
                st--;
                end++;
            }

            // Even length
            st = i - 1;
            end = i;
            while (st >= 0 && end < n && s.charAt(st) == s.charAt(end)) {
                ispal[st][end] = true;
                st--;
                end++;
            }
        }

        // Now pre-calculate the number of palindromic substrings between every possible i and j.
        for (int len = 0; len < n; len++) {
            for (int i = 0, j = i + len; j < n; j++, i++) {
                if (len == 0) {
                    dp[i][j] = 1; // If len==0, it means i==j, which is always a palindrome.
                } else {
                    if (ispal[i][j]) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + 1; // To calculate the answer for i to j, first calculate the answer for i to j-1 and i+1 to j, then remove the common [i+1,j-1] part.
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
            }
        }

        while (q-- > 0) {
            String[] tokens = reader.readLine().split(" ");
            int l = Integer.parseInt(tokens[0]) - 1;
            int r = Integer.parseInt(tokens[1]) - 1;
            writer.write(dp[l][r] + "\n");
        }

        writer.flush();
    }
}



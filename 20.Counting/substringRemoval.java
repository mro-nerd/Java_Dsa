/*
->You have a string s of length n made of lowercase letters.
->You must remove exactly one substring (a contiguous part).
->After removal, the remaining string should consist of only one type of letter (or be empty).
->Count how many different substrings can be removed to achieve this.
->Answer should be modulo 998244353.

Conditions:

->The string has at least two different characters.
->The substring removed must contain at least one character. */

import java.util.*;

public class substringRemoval {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();

        int prefCount = 0, suffCount = 0;

        // Count prefix of same characters as s[0]
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt(0)) {
                prefCount++;
            } else {
                break;
            }
        }

        // Case 1: All characters equal
        if (prefCount == n) {
            long ans = (1L * n * (n + 1) / 2) % MOD;
            System.out.println(ans);
            return;
        }

        // Count suffix of same characters as s[n-1]
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(n - 1)) {
                suffCount++;
            } else {
                break;
            }
        }

        long ans;
        if (s.charAt(0) == s.charAt(n - 1)) {
            // Case 2B: First == Last
            ans = (1L * (prefCount + 1) * (suffCount + 1)) % MOD;
        } else {
            // Case 2A: First != Last
            ans = (prefCount + suffCount + 1L) % MOD;
        }

        System.out.println(ans);
    }
}

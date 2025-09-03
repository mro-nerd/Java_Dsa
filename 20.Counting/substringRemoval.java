/*
Problem:
---------
We are given a string s of length n (only lowercase letters).
We must remove exactly one substring such that:
    - The remaining string has only one type of character (all equal), OR is empty.
We need to count the number of possible substrings that can be removed.
Answer must be given modulo 998244353.

Key Insights:
-------------
1. The string must become "uniform" (all one character) after removal.
   → This means that:
     - All characters in the prefix (left part) must be the same,
     - All characters in the suffix (right part) must be the same,
     - And the removed substring is in between.

2. Cases:
   Case 1: All characters are already the same.
       - Removing any substring is valid.
       - Number of substrings = n*(n+1)/2.

   Case 2: String has at least 2 different characters.
       - Let prefCount = length of prefix where all chars equal s[0].
       - Let suffCount = length of suffix where all chars equal s[n-1].

       Case 2A: If s[0] != s[n-1]:
           - We can either remove after the prefix OR before the suffix.
           - Total = prefCount + suffCount + 1

       Case 2B: If s[0] == s[n-1]:
           - We can "connect" prefix and suffix by deleting the middle part.
           - Total = (prefCount + 1) * (suffCount + 1)

Why these formulas?
-------------------
- The "+1" comes from the choice of deleting the *whole substring* 
  between prefix and suffix boundaries.
- In Case 2B, we multiply because we can independently choose
  how many extra characters from prefix and suffix to "keep".
*/

import java.util.*;

public class substringRemoval {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();

        int prefCount = 0, suffCount = 0;

        // Count how many characters in the prefix are equal to s[0]
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt(0)) {
                prefCount++;
            } else {
                break; // stop when different character appears
            }
        }

        // Case 1: If the entire string is made of the same character
        if (prefCount == n) {
            // Total substrings = n*(n+1)/2
            long ans = (1L * n * (n + 1) / 2) % MOD;
            System.out.println(ans);
            return;
        }

        // Count how many characters in the suffix are equal to s[n-1]
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(n - 1)) {
                suffCount++;
            } else {
                break; // stop when different character appears
            }
        }

        long ans;
        if (s.charAt(0) == s.charAt(n - 1)) {
            // Case 2B: First and last characters are equal
            // Independent choices for prefix & suffix → multiply
            ans = (1L * (prefCount + 1) * (suffCount + 1)) % MOD;
        } else {
            // Case 2A: First and last characters are different
            // Only linear choices → add
            ans = (prefCount + suffCount + 1L) % MOD;
        }

        System.out.println(ans);
    }
}

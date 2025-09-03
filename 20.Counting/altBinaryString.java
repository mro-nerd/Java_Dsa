/*
Problem:
---------
We are given a binary string s (characters are '0' or '1').
We want to make the string alternating ("0101..." or "1010...")
by deleting characters. We can delete any characters, any number of times.

We need to find:
1. The minimum number of deletions (operations) required.
2. The number of different shortest sequences of deletions that achieve this 
   (answer modulo 998244353).

Key Observations:
-----------------
1. An alternating string has no two equal consecutive characters.
   So, all "runs" (consecutive equal characters) longer than 1 must be shortened.

2. Let’s break s into runs of consecutive equal characters.
   Example: s = "0011100"
       runs = [2,3,2]  (2 zeros, 3 ones, 2 zeros)

3. Minimum deletions:
   If we have k runs, the resulting alternating string has length k.
   So, deletions = n - k  (because we must delete everything except 1 char per run).

4. Number of different ways:
   - In each run of length L, we must keep exactly 1 character, so we have L choices.
   - Multiply these choices across all runs → product of run lengths.
   - But order of deletions also matters (different sequences).
     Once we decide which characters remain, the deletions form a permutation 
     of (n - k) elements. So, multiply by (n - k)!.

   Final formula:
       ways = (product of all run lengths) * (n - k)!   (mod 998244353)
*/

import java.util.ArrayList;
import java.util.Scanner;

public class altBinaryString {
    public static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases

        while (t-- > 0) {
            String s = scanner.next();
            long ways = 1; // number of ways (modulo MOD)
            ArrayList<Integer> runs = new ArrayList<>();

            int len = 1; // current run length
            int runCount = 1; // total number of runs
            int n = s.length();

            // Step 1: Build the run-length encoding of the string
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    len++; // still in the same run
                } else {
                    runs.add(len); // save the finished run
                    len = 1;       // reset for next run
                    runCount++;
                }
            }
            runs.add(len); // add the last run

            // Step 2: Multiply choices for each run
            for (int runLen : runs) {
                ways = (ways * runLen) % MOD;
            }

            // Step 3: Multiply by factorial of deletions count
            // deletions = n - runCount
            for (int i = 1; i <= n - runCount; i++) {
                ways = (ways * i) % MOD;
            }

            // Step 4: Print results
            // Minimum operations = n - runCount
            System.out.println((n - runCount) + " " + ways);
        }
    }
}

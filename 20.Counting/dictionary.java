/*
Problem:
---------
We define "Berland words":
- Each word has exactly 2 lowercase letters.
- Both letters must be different (e.g., "ab", "zx" are valid, "aa" is not).

We sort all valid words in dictionary order (lexicographic order).
We want to find the position (index) of a given word in this dictionary.

Example:
---------
Dictionary starts:
    "ab" -> 1
    "ac" -> 2
    ...
    "az" -> 25
    "ba" -> 26
    "bc" -> 27
    ...
So index is 1-based.

Key Idea:
----------
1. There are 26 letters.
   For each possible first letter:
     - There are 25 valid second letters (everything except the same letter).

2. Suppose our word = s = "xy".
   Let:
       a = index of first letter (0-based, 'a' = 0, 'b' = 1, ...)
       b = index of second letter (same mapping)

3. How to compute index?
   - For each first letter smaller than 'x', we skip 25 words.
     → contribution = a * 25
   - Within the block of words starting with 'x':
       * If b > a, then its order is just b (because the second letter shifts
         due to skipping the identical case).
       * If b < a, then its order is b + 1 (since one smaller option is skipped).

   So:
       if (a < b): index = a * 25 + b
       else:       index = a * 25 + b + 1

This gives the correct 1-based position in dictionary order.
*/

import java.util.*;

public class dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            String s = sc.next();

            // Convert characters to 0-based indices
            int a = s.charAt(0) - 'a'; // first letter
            int b = s.charAt(1) - 'a'; // second letter

            int ans;

            if (a < b) {
                // Case 1: second letter is after first letter in alphabet
                // So, order is straightforward
                ans = a * 25 + b;
            } else {
                // Case 2: second letter is before first letter
                // We must "skip" the forbidden case (aa, bb, etc.)
                ans = a * 25 + b + 1;
            }

            System.out.println(ans);
        }
    }
}

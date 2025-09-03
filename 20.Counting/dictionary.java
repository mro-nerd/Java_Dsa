/*Berland words:
->Each word has exactly 2 lowercase letters.
->Condition: the first letter ≠ second letter.
So valid words: "ab", "ac", "zx", … but not "aa", "zz".

Dictionary order:
->Words are sorted just like in English dictionary:
->Compare first letter → smaller comes first.
->If first letters are equal → compare second letter.

Example dictionary beginning:

"ab" → 1
"ac" → 2
…
"az" → 25
"ba" → 26
"bc" → 27
… etc.

Given a valid Berland word s, find its index in this dictionary. */

import java.util.*;

public class dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            String s = sc.next();
            int a = s.charAt(0) - 'a'; // first letter index
            int b = s.charAt(1) - 'a'; // second letter index

            int ans;
            if (a < b) {
                ans = a * 25 + b;
            } else {
                ans = a * 25 + b + 1;
            }
            System.out.println(ans);
        }
    }
}

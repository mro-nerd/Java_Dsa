/*You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:
"1" -> 'A'
"2" -> 'B'
...
"25" -> 'Y'
"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").
For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:

Input: s = "12"

Output: 2

Explanation:

"12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: s = "226"

Output: 3

Explanation:

"226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6). */

import java.util.Scanner;

public class decodeWays {
     private static boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        int x = Integer.parseInt(s);
        return x >= 1 && x <= 26;
    }
    
    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') dp[1] = 0;
        else dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            String s1 = s.substring(i - 1, i);
            String s2 = s.substring(i - 2, i);
            if (isValid(s1)) dp[i] += dp[i - 1];
            if (isValid(s2)) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(numDecodings(s));
    }
}

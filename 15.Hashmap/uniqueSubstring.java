/*Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. */

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;

        Map<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        while (j < n) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            while (mp.get(ch) > 1) {
                char removed = s.charAt(i++);
                mp.put(removed, mp.get(removed) - 1);
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}

public class uniqueSubstring {
    public static void main(String[] args) {
        // Sample input
        String s = "abcabcbb";

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the lengthOfLongestSubstring method
        int result = solution.lengthOfLongestSubstring(s);

        // Output the result
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }
}



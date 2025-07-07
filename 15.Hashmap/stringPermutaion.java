/*Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false */

import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();
        
        // Populate the frequency maps for s1 and the initial window in s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }

        // Sliding window over s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (s1Count.equals(s2Count)) return true;

            // Adjust the window
            char startChar = s2.charAt(i);
            char endChar = s2.charAt(i + s1.length());

            s2Count.put(startChar, s2Count.get(startChar) - 1);
            if (s2Count.get(startChar) == 0) {
                s2Count.remove(startChar);
            }
            s2Count.put(endChar, s2Count.getOrDefault(endChar, 0) + 1);
        }

        // Check the last window
        return s1Count.equals(s2Count);
    }
}

public class stringPermutaion {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example Test Cases
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(solution.checkInclusion(s1, s2)); // Output: true

        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(solution.checkInclusion(s1, s2)); // Output: false
    }
}



/*You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:

Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
Return the lexicographically smallest string that can be written on the paper.

Example 1:

Input: s = "zza"
Output: "azz"
Explanation: Let p denote the written string.
Initially p="", s="zza", t="".
Perform first operation three times p="", s="", t="zza".
Perform second operation three times p="azz", s="", t="".
Example 2:

Input: s = "bac"
Output: "abc"
Explanation: Let p denote the written string.
Perform first operation twice p="", s="c", t="ba". 
Perform second operation twice p="ab", s="c", t="". 
Perform first operation p="ab", s="", t="c". 
Perform second operation p="abc", s="", t="". */

public class robotPrint {

    static String robotWithString(String s) {
        int n = s.length();
        char[] minRight = new char[n];
        minRight[n - 1] = s.charAt(n - 1);

        // Compute min character from i to end
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = s.charAt(i) <= minRight[i + 1] ? s.charAt(i) : minRight[i + 1];
        }

        StringBuilder paper = new StringBuilder();
        StringBuilder t = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            t.append(s.charAt(i));
            char minChar = i + 1 < n ? minRight[i + 1] : minRight[i];

            // Pop from stack if top <= minimum future character
            while (t.length() > 0 && t.charAt(t.length() - 1) <= minChar) {
                paper.append(t.charAt(t.length() - 1));
                t.deleteCharAt(t.length() - 1);
            }
            i++;
        }

        // Empty remaining stack
        while (t.length() > 0) {
            paper.append(t.charAt(t.length() - 1));
            t.deleteCharAt(t.length() - 1);
        }

        return paper.toString();
    }
    // Main function to test the method
    public static void main(String[] args) {
        String input = "bac";
        String output = robotWithString(input);
        System.out.println("Output: " + output);
    }
}


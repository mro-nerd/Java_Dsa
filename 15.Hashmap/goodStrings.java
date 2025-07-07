/*You are given an array of strings words and a string chars.A string is good if it can be formed by characters from chars (each character can only be used once).Return the sum of lengths of all good strings in words.

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6. */

class Solution {
    public boolean canForm(String word, int[] count) {
        int[] c = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            c[k]++;
            if (c[k] > count[k])
                return false;
        }
        return true;
    }

    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            count[chars.charAt(i) - 'a']++;
        }

        int res = 0;
        for (String word : words) {
            if (canForm(word, count))
                res += word.length();
        }
        return res;
    }
}

public class goodStrings {
    public static void main(String[] args) {
        // Sample input
        String[] words = { "cat", "bt", "hat", "tree" };
        String chars = "atach";

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the countCharacters method
        int result = solution.countCharacters(words, chars);

        // Output the result
        System.out.println("The total length of words that can be formed is: " + result);
    }
}

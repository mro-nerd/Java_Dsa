/*You are given a string s. It may contain any number of '*' characters. Your task is to remove all '*' characters.
While there is a '*', do the following operation:

->Delete the leftmost '*' and the smallest non-'*' character to its left. If there are several smallest characters, you can delete any of them.
->Return the lexicographically smallest resulting string after removing all '*' characters.

Example 1:
Input: s = "aaba*"

Output: "aab"

Explanation:
We should delete one of the 'a' characters with '*'. If we choose s[3], s becomes the lexicographically smallest. */

import java.util.ArrayDeque;
import java.util.Deque;

public class minString {

    static String clearStars(String s) {
        Deque<Integer>[] cnt = new Deque[26];//deque can act as queue or stack in java depending on fn we are using (we are using stack fn on it here like push(), pop()).We use it because it  is  more faster and newer class then stack class
        for (int i = 0; i < 26; i++) {
            cnt[i] = new ArrayDeque<>();
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                cnt[arr[i] - 'a'].push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!cnt[j].isEmpty()) {
                        arr[cnt[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    // Main function to test the method
    public static void main(String[] args) {
        // Test case
        String input = "abc*dea*f";
        String output = clearStars(input);

        // Printing the result
        System.out.println("Output: " + output);
    }
}

/*Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:

>>Insert a character
>>Delete a character
>>Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e') */

class editDistance {
    // Function to calculate the minimum edit distance between two strings
    static int editDistances(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        // Create two arrays to store the previous and current rows of minimum edit distances
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        // Initialize the first row with their respective indices
        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        // Fill the cur array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
            cur[0] = i;
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    // If the characters match, no edit is needed, so take the value from the diagonal.
                    cur[j] = prev[j - 1];
                } else {
                    // If the characters don't match, take the minimum of three possibilities:
                    // 1. Replace the character in S1 with the character in S2 (diagonal).
                    // 2. Delete the character in S1 (left).
                    // 3. Insert the character from S2 into S1 (up).
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
                }
            }
            // Update prev array to store the current values
            prev = cur.clone();
        }

        return prev[m];
    }

    public static void main(String args[]) {
        String s1 = "";
        String s2 = "a";

        System.out.println("The minimum number of operations required is: " +
                editDistances(s1, s2));
    }
}
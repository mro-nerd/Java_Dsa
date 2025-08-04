/*You are given two strings s1 and s2. Your task is to find the length of the longest common substring among the given strings.

Examples:

Input: s1 = "ABCDGH", s2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" with a length of 4. */

public class longestCommonSubstring {
     static int longestCommonSubstr(String s1, String s2, int n, int m){
         // Create a 2D DP table with dimensions (n+1) x (m+1)
        int[][] dp = new int[n+1][m+1];
    
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    int val = 1 + dp[i-1][j-1]; // Characters match, increment substring length
                    dp[i][j] = val; // Update the DP table
                }
                else
                    dp[i][j] = 0; // Characters don't match, substring length becomes 0
            }
        }
        
        int maxLen = 0; // Now finding the max element
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++)
                maxLen = Math.max(maxLen, dp[i][j]);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s1 = "ABCDGH", s2 = "ACDGHR";
        int ans=longestCommonSubstr(s1,s2,s1.length(),s2.length());
        System.out.println(ans);

    }
}

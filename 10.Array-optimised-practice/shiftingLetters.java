/*You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.

Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').

Return the final string after all such shifts to s are applied.

 

Example 1:

Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
Output: "ace"
Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
Finally, shift the characters from index 0 to index 2 forward. Now s = "ace". */


public class shiftingLetters {
    public static void main(String[] args){
      String s="dztz";
      int shifts[][]={{0,0,0},{1,1,1}};
      System.out.println(shiftingLetter(s, shifts));
    }
    public static String shiftingLetter(String s, int[][] shifts) {
        int n=s.length();
        int pre[]=new int[n+1];
        for(int[]shift:shifts){
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];
            if(dir==1){
                pre[start]++;
                pre[end+1]--;
            }
            else{
                pre[start]--;
                pre[end+1]++;
            }
        }
        for(int i=1;i<=n;i++){
            pre[i]+=pre[i-1];
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int shiftedIndex = (charArray[i] - 'a' + pre[i]) % 26;
            if (shiftedIndex < 0) {
                shiftedIndex += 26;
            }
            charArray[i] = (char) ('a' + shiftedIndex);
        }
        return new String(charArray);
    }
}

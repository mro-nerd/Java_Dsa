//# given a String array words and 2D int array queries such that .
//queries[i]=[l,r]
//return the ans array which finds the number of strings in words that starts and end with vowel in the given range from l to r given in queries array

public class vowelInRanges {
    public static void main(String[] args){
        String words[]={"aba","bcb","ece","aa","e"};
        int qrueries[][]={{0,2},{1,4},{1,1}};
        int result[]=vowelStrings(words, qrueries);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
    public static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                pre[i] = 1;
            } else {
                pre[i] = 0;
            }
            if (i >= 1) {
                pre[i] += pre[i - 1];
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                ans[i] = pre[r];
            } else {
                ans[i] = pre[r] - pre[l - 1];
            }
        }
        return ans;
    }
}

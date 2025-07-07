// # give the length of longest substring whith all unique characters.

import java.util.Scanner;

public class uniqueSubstring{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.print(longestUniqueSubsttr(s));
        sc.close();
    }
   public static  int longestUniqueSubsttr(String S){
        int n = S.length();
		int ans = 1;
		int i = 0;
		int j = 0;
		int[] freq = new int[26];
		freq[S.charAt(0)-'a']++;
		while(j<n-1) {
			j++;
			freq[S.charAt(j)-'a']++;
			while(freq[S.charAt(j)-'a']==2) {
				freq[S.charAt(i)-'a']--;
				i++;
			}
			ans = Math.max(ans, j-i+1);
		}
		return ans;
    }

}
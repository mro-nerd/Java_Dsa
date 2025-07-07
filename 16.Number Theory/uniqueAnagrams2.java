/*You are given a string s containing one or more words. Every consecutive pair of words is separated by a single space ' '.
A string t is an anagram of string s if the ith word of t is a permutation of the ith word of s.

For example, "acb dfe" is an anagram of "abc def", but "def cab" and "adc bef" are not.
Return the number of distinct anagrams of s. Since the answer may be very large, return it modulo 109 + 7.

Example 1:

Input: s = "too hot"
Output: 18
Explanation: Some of the anagrams of the given string are "too hot", "oot hot", "oto toh", "too toh", and "too oht".
 */

import java.util.*;


public class uniqueAnagrams2 {

    private static final int MOD = 1000000007;

    static int countAnagrams(String s) {
        String[] strs = s.split(" ");
        long result = 1;
        int maxLen = 0;

        for (String str : strs) {            
            maxLen = Math.max(maxLen, str.length());
        }

        int[] factorial = getFactorial(maxLen);
        int[] invFactorial = getInverseFactorial(maxLen, factorial);
        int[] count = new int[26];
        int len;
        long numOfPermutations;

        for (String str : strs) {
            Arrays.fill(count, 0);
            len = str.length();
            for (int i = 0; i < len; i++) {
                count[str.charAt(i) - 'a']++;
            }

            numOfPermutations = factorial[len];

            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    numOfPermutations = (numOfPermutations * invFactorial[count[i]]) % MOD;
                }
            }

            result = (result * numOfPermutations) % MOD;
        }
        return (int) result;
    }

    static int[] getFactorial(int num) {
        int[] factorial = new int[num + 1];
        factorial[0] = 1;
        for (int i = 1; i <= num; i++) {
            factorial[i] = (int) ((1L * factorial[i - 1] * i) % MOD);
        }
        return factorial;
    }

    static int[] getInverseFactorial(int num, int[] factorial) {
        int[] invFactorial = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            invFactorial[i] = (int) powMod(factorial[i], MOD - 2) % MOD;//Fermat's little theorem
        }
        return invFactorial;
    }

    static long powMod(long num, int pow) {
        long result = 1;
        while (pow >= 1) {
            if (pow % 2 == 1) {
                result = (result * num) % MOD;
            }
            pow /= 2;
            num = (num * num) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String s = scanner.nextLine();
        scanner.close();

        int result = countAnagrams(s);
        System.out.println("Number of anagram permutations: " + result);

        scanner.close();
    }

}

    

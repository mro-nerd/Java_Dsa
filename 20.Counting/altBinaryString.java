/*You are given a binary string s. A binary string is a string consisting of characters 0 and/or 1.
You can perform the following operation on s any number of times (even zero):

->choose an integer i
 such that 1≤i≤|s|, then erase the character si.
->You have to make s
 alternating, i. e. after you perform the operations, every two adjacent characters in s should be different.

Your goal is to calculate two values:

->the minimum number of operations required to make s alternating
->the number of different shortest sequences of operations that make s alternating. Two sequences of operations are different if in at least one operation, the chosen integer i is different in these two sequences.

*/

import java.util.ArrayList;
import java.util.Scanner;

public class altBinaryString {
    public static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            long mul = 1;
            ArrayList<Integer> v = new ArrayList<>();
            int len = 1, k = 1;
            int n = s.length();
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    len++;
                } else {
                    v.add(len);
                    len = 1;
                    k++;
                }
            }
            v.add(len);
            for (int i = 0; i < v.size(); i++) {
                mul = (mul * v.get(i)) % MOD;
            }
            for (int i = 1; i <= n - k; i++) {
                mul = (mul * i) % MOD;
            }
            System.out.println((n - k) + " " + mul);
        }
    }
}

/*Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example 1:

Input: a = 2, b = [3]
Output: 8
Example 2:

Input: a = 2, b = [1,0]
Output: 1024 */

import java.util.*;

class Solution {
    final int mod = 1337;

    int mul(int a, int b) {
        return ((a % mod) * (b % mod)) % mod;
    }

    int powUnderMod(int a, int n) {
        if (n == 0)
            return 1;
        int partialAns = powUnderMod(a, n / 2);

        partialAns = mul(partialAns, partialAns);

        if (n % 2 == 0)
            return partialAns;

        return mul(partialAns, a);
    }

    public int superPow(int a, int[] b) {
        int ans = 1;
        a %= mod;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = mul(ans, powUnderMod(a, b[i]));
            a = powUnderMod(a, 10);
        }
        return ans;
    }
}

public class superPow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base number (a): ");
        int a = scanner.nextInt();

        System.out.print("Enter exponent array length: ");
        int len = scanner.nextInt();
        int[] b = new int[len];

        System.out.print("Enter exponent array elements: ");
        for (int i = 0; i < len; i++) {
            b[i] = scanner.nextInt();
        }

        Solution sol = new Solution();
        int result = sol.superPow(a, b);

        System.out.println("Result: " + result);

        scanner.close();
    }
    
}

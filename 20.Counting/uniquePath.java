/*
Problem:
---------
We are given an m*n grid. Starting from the top-left cell (1,1), 
we want to reach the bottom-right cell (m,n).

Allowed moves: 
- Only "right" or "down" at each step.

We need to count the number of unique paths to reach (m,n).
Since the answer can be large, return it modulo 1e9+7.

Mathematical Intuition:
------------------------
To go from (1,1) to (m,n), we need to make:
    - (m-1) moves down
    - (n-1) moves right
Total moves = (m-1) + (n-1) = (m + n - 2).

So, the problem reduces to:
    "In how many ways can we arrange (m-1) downs and (n-1) rights?"

This is a combinatorics problem:
    Answer = C(m+n-2, m-1) = (m+n-2)! / [(m-1)! * (n-1)!]

We use modular arithmetic and precompute factorials to handle large inputs.
*/

import java.util.*;

public class uniquePath {
    static final long mod = 1000000007; // Modulo for large numbers
    static long fact[]; // Array to store factorial values modulo mod

    // Fast exponentiation: computes (a^n) % mod
    static long pwmd(long a, long n) {
        if (n == 0) 
            return 1;
        long pt = pwmd(a, n / 2);
        pt = (pt * pt) % mod;
        if ((n & 1) > 0) { // if n is odd
            pt = (pt * a) % mod;
        }
        return pt;
    }

    // Modular inverse using Fermat’s Little Theorem
    // Since mod is prime, a^(mod-2) ≡ a^(-1) (mod)
    static long modInv(long a) {
        return pwmd(a, mod - 2);
    }

    // Precompute factorials up to 200000! modulo mod
    static void pre() {
        fact = new long[200001];
        fact[0] = 1;
        for (int i = 1; i <= 200000; ++i)
            fact[i] = (fact[i - 1] * i) % mod;
    }

    // Function to compute nCr % mod
    static long C(int n, int r) {
        if (n < r) // Invalid case
            return 0;
        long num = fact[n]; // n!
        long den = (fact[r] * fact[n - r]) % mod; // r! * (n-r)!
        return (num * modInv(den)) % mod;
    }

    public static void main(String[] args) {
        pre(); // Precompute factorials once
        Scanner sc = new Scanner(System.in);
        long q = sc.nextLong(); // Number of test cases
        while (q-- > 0) {
            int n = sc.nextInt(); // Rows
            int m = sc.nextInt(); // Columns
            // Number of unique paths = C(m+n-2, n-1) or C(m+n-2, m-1)
            System.out.println(C(n + m - 2, n - 1));
        }
    }
}

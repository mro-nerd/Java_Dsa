/*
Problem:
---------
We want to count arrays of length n, with elements from [1..m], such that:
1. Exactly one pair of equal elements (all others distinct).
2. The array forms a "mountain":
     - strictly increasing up to some peak index,
     - strictly decreasing afterwards.

Example:
---------
Input: n=3, m=4
Output: 6
Valid arrays:
    [1,2,1], [1,3,1], [1,4,1],
    [2,3,2], [2,4,2],
    [3,4,3]

Key Combinatorial Idea:
-----------------------
1. **Distinct + one duplicate**:
   - We need exactly (n-1) distinct values.
   - From m possible numbers, choose (n-1) distinct numbers.
   → ways = C(m, n-1)

2. **Where to place the duplicate?**
   - The duplicate must appear on both sides of the peak (to keep the mountain valid).
   - So the duplicate is at the "left slope" and "right slope".
   - Number of choices for duplicate placement = (n-2)
     (we cannot duplicate at the peak, only before & after).

3. **Arrangement of remaining (n-3) elements:**
   - Once the duplicate is chosen, the rest must be split into:
       - some on the increasing side,
       - some on the decreasing side.
   - There are 2^(n-3) ways to split them 
     (each of the other (n-3) distinct elements can go either left or right).

4. Multiply everything:
   Answer = C(m, n-1) * (n-2) * 2^(n-3)

Special case:
-------------
If n = 2, impossible to satisfy → answer = 0.

Modulo:
--------
We compute everything modulo 998244353 using:
   - Precomputed factorials (via `fact`)
   - Modular inverse for binomial coefficient
   - Fast exponentiation for powers of 2
*/

import java.util.*;

public final class countArrays {
    
    static final long mod = 998244353;

    // Fast exponentiation: computes (a^n) % mod
    static long powMod(long a,long n) {
        if(n == 0) return 1;
        long pt = powMod(a, n/2);
        pt = (pt * pt) % mod;
        if((n & 1) > 0) {
            pt = (pt * a) % mod;
        }
        return pt;
    }

    // Modular inverse using Fermat’s little theorem (since mod is prime)
    static long modInv(long a) {
        return powMod(a, mod - 2);
    }

    // Factorial modulo mod
    static long fact(long n) {
        long ans = 1L;
        for(long i = 1L; i <= n; ++i)
            ans = (ans * i) % mod;
        return ans;
    }

    // Binomial coefficient C(n, r) % mod
    static long C(long n, long r) {
        if(r > n) return 0;
        long num = fact(n);
        long den = (fact(r) * fact(n-r)) % mod;
        return (num * modInv(den)) % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); // array length
        long m = sc.nextLong(); // range of values

        // Base case: if n=2, impossible to form mountain with duplicate
        if(n == 2) {
            System.out.println(0);
            return;
        }

        // Formula: C(m, n-1) * (n-2) * 2^(n-3)
        long ans = C(m, n - 1);
        ans = (ans * (n-2)) % mod;
        ans = (ans * powMod(2, n - 3)) % mod;

        System.out.println(ans);
    }
}

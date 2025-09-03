/*You need to count how many arrays satisfy all the following conditions:
The array has n elements.

->Each element is an integer between 1 and m (inclusive).
->The array contains exactly one pair of equal elements — all other elements must be distinct.
->The array forms a mountain shape:
    There is an index i such that:
     
    *All elements before index i are in strictly increasing order.
    *All elements from index i onward are in strictly decreasing order. 
Ex:
Input: 3 4 //n m
Output: 6
Explaination: 
[1,2,1]
[1,3,1]
[1,4,1]
[2,3,2]
[2,4,2]
[3,4,3]
*/

import java.util.*;

public final class countArrays {
    
    static final long mod = 998244353;
    
    static long powMod(long a,long n) { // modulo inverse
        if(n == 0)
            return 1;
        long pt = powMod(a,n/2);
        pt*=pt;
        pt%=mod;
        if((n&1) > 0) {
            pt*=a;
            pt%=mod;
        }
        return pt;
    }

    static long modInv(long a) {
        return powMod(a, mod - 2);
    }
    
    static long fact(long n) {
        long ans = 1l;
        for(long i = 1l; i <= n; ++i)
            ans = (ans * i)%mod;
        return ans;
    }

    static long C(long n, long r) {
        if(r > n)
            return 0;
        
        long num = fact(n);
        long den = (fact(r) * fact(n-r)) % mod;

        return (num * modInv(den)) % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        if(n == 2) {
            System.out.println(0);
            return;
        }

        // mCn-1 * (n-2) * 2^(n-3)
        long ans = C(m, n - 1);
        ans = (ans * (n-2)) % mod;
        ans = (ans * powMod(2, n - 3)) % mod;

        System.out.println(ans);
    }
}
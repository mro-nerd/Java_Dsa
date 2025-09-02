/*You are given m*n matrix and you need to reach on last cell i.e (m-1)(n-1). Your starting position is (1)(1) find find no. of ways to reach to last cell.  */

import java.util.*;

public class uniquePath{
    static final long mod = 1000000007;
    static long fact[];

    static long pwmd(long a,long n) { // modulo inverse
        if(n == 0)
            return 1;
        long pt = pwmd(a,n/2);
        pt*=pt;
        pt%=mod;
        if((n&1) > 0) {
            pt*=a;
            pt%=mod;
        }
        return pt;
    }

    static long modInv(long a) {
        return pwmd(a, mod - 2);
    }

    static void pre() {
        fact = new long[200001];
        fact[0] = 1;
        for(int i = 1; i <= 200000; ++i)
            fact[i] = (fact[i-1] * i) % mod;
    }

    static long C(int n, int r) {
        if(n < r)
            return 0;
            
        long num = fact[n];
        long den = (fact[r] * fact[n-r]) % mod;

        return (num * modInv(den)) % mod;
    }
    
    public static void main(String[] args) {
        pre();
        Scanner sc = new Scanner(System.in);
        long q = sc.nextLong();
        while(q-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(C(n + m - 2, n - 1));// (m+n-2)!/(m-1)!(n-1)!
        }
    }
}
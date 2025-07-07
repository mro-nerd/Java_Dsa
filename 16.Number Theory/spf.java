/*Return the SPF(smallest prime factor) array of giben length n.  */

public class spf {
    static int[] primeSieve(int n) {
        int[] spf = new int[n+1]; // initially 0

        for(int i = 2; i <= n; ++i) {
            if(spf[i] > 0)
                continue;
            spf[i] = i;
            if((long)i*i > (long)n)
                continue;
            for(int j = i*i; j <= n; j += i)
                if(spf[j] == 0)
                    spf[j] = i;
        }

        return spf;
    }
    public static void main(String[] args) {
        int n = 30;
        int[] spf = primeSieve(n);
        for(int i = 2; i <= n; ++i)
            System.out.println(i + ": " + spf[i]);
    }
}

/*If 0<=a,b,m<=10^15 find (a*b)%m */

import java.util.*;

public class moduloProduct {

    static long modProduct(long a, long b, long m) {
        if(b == 0)
            return 0;

        long halfAns = modProduct(a, b/2, m);

        if(b%2 == 0)
            return (halfAns + halfAns)%m;
        
        return (halfAns + halfAns + a)%m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long m = sc.nextLong();
        sc.close();
        System.out.println(modProduct(a, b, m));
    }
}


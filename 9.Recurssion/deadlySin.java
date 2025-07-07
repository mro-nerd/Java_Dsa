/*Meliodas and Ban are fighting over chocolates. Meliodas has 𝑋X chocolates, while Ban has 𝑌
. Whoever has lesser number of chocolates eats as many chocolates as he has from the other's collection. This eatfest war continues till either they have the same number of chocolates, or atleast one of them is left with no chocolates.
Can you help Elizabeth predict the total no of chocolates they'll be left with at the end of their war? 
ex: M=5 B=3 
now B will take 3 choclates from M
=> M=2 B=3
now M will take 2 choclates from B
=> M=2 B=1
now B will take 1 choclate from M
=>M=1 B=1 now total remaining choclates are 2.*/

import java.util.*;

public class deadlySin {

public static int rec(int n, int m) {
        if (n == m || n == 0 || m == 0)
            return n + m;
        if (n < m) {
            m=m%n;
            if(m==0) m=n;
            return rec(m , n);
        }
        else{
            n=n%m;
            if(n==0) n=m;
            return rec(m,n);
        }
       
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(rec(n, m));
        }
        scanner.close();
    }


}

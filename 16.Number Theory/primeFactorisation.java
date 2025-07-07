/*Give the prime factors of given number */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class primeFactorisation {
    static TreeMap<Integer,Integer> primeFactors(int n) {
        TreeMap<Integer,Integer> ans = new TreeMap<>();
        for(int i = 2; i*i <= n; ++i) {
            if(n%i != 0)
                continue;
            int power = 0;
            while(n%i == 0) {
                n /= i;
                power += 1;
            }
            ans.put(i, power);
        }
        if(n > 1)
            ans.put(n, 1);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        TreeMap<Integer,Integer> ans = primeFactors(n);
        for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

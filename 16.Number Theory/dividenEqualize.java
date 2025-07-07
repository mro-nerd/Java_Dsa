/*You are given an array a containing n positive integers. You can perform the following operation on the array any number of times (including zero times):

->Choose two elements ai and aj from the array such that i ≠ j.
->Choose a divisor x of ai (that means x is a positive integer such that ai % x == 0).
->Replace ai with ai / x, and replace aj with aj * x.

Your task is to determine whether it is possible to make all the elements in the array equal by performing the above operation any number of times.

Example:

Let the array be:
a = [100, 2, 50, 10, 1]

Perform the following operations:

Choose a3 = 50 and a2 = 2. Choose x = 5 (since 5 divides 50).
Replace a3 with 50 / 5 = 10
Replace a2 with 2 * 5 = 10
Now the array becomes: [100, 10, 10, 10, 1]

Choose a1 = 100 and a5 = 1. Choose x = 10 (since 10 divides 100).
Replace a1 with 100 / 10 = 10
Replace a5 with 1 * 10 = 10
Now the array becomes: [10, 10, 10, 10, 10]

So, the answer is YES */

import java.util.*;

public class dividenEqualize {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer,Integer> primeFreq = new HashMap<>();
            for(int i = 0; i < n; ++i) {
                int ai = sc.nextInt();
                for(int num = 2; num*num <= ai; ++num) {
                    while(ai % num == 0) {
                        primeFreq.put(num, primeFreq.getOrDefault(num, 0) + 1);
                        ai /= num;
                    }
                }
                if(ai > 1)
                    primeFreq.put(ai, primeFreq.getOrDefault(ai, 0) + 1);
            }

            // Powers of all the primes should
            // be a multiple of n
            String ans = "YES";
            for(int prime : primeFreq.keySet()) {
                int freq = primeFreq.get(prime);
                if(freq % n != 0) {
                    ans = "NO";
                    break;
                }
            }

            System.out.println(ans);
        }
    }
}


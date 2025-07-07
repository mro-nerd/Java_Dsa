/*A number is called almost prime if it has exactly two distinct prime divisors. For example, numbers 6, 18, 24 are almost prime, while 4, 8, 9, 42 are not. Find the amount of almost prime numbers which are between 1 and n, inclusive.

Input
Input contains one integer number n (1 ≤ n ≤ 3000).

Output
Output the amount of almost prime numbers between 1 and n, inclusive. */

import java.util.Scanner;

public class almostPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int[] countPrimeDivisors = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (countPrimeDivisors[i] == 0) { // means it is prime number
                for (int j = 2 * i; j <= n; j += i) {
                    countPrimeDivisors[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (countPrimeDivisors[i] == 2)
                ans++;
        }
        System.out.println(ans);
    }
}

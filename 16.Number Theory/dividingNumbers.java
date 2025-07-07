/*You are given two integers a and b. In one turn, you can do one of the following operations:
>>Take an integer c (c>1 and a should be divisible by c) and replace a with a/c;
>>Take an integer c (c>1 and b should be divisible by c) and replace b with b/c.

Your goal is to make a equal to b using exactly k turns.
For example, the numbers a=36 and b=48 can be made equal in 4 moves:
c=6, divide b by c ⇒ a=36, b=8;
c=2, divide a by c ⇒ a=18, b=8;
c=9, divide a by c ⇒ a=2, b=8;
c=4, divide b by c ⇒ a=2, b=2. */

import java.util.*;

public class dividingNumbers {

    static Scanner sc = new Scanner(System.in);

    static void solve() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();
        int af = factor(a);
        int bf = factor(b);
        if (k == 1 && a != b && (a % b == 0 || b % a == 0)) {
            System.out.println("Yes");
            return;
        }
        if (k != 1 && k <= af + bf) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");

    }

    public static int factor(int n) {
        int count = 0;

        // Handle factor 2 quickly
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }

        // Try odd factors from 3 up to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                count++;
                n /= i;
            }
        }

        // If remaining n is a prime > sqrt(n)
        if (n > 1) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int test = sc.nextInt();
        while (test-- > 0) {
            solve();
        }

    }
}


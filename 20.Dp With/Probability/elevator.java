/*Ilya got tired of sports programming, left university and got a job in the subway. He was given the task to determine the escalator load factor.

Let's assume that n people stand in the queue for the escalator. At each second one of the two following possibilities takes place: either the first person in the queue enters the escalator with probability p, or the first person in the queue doesn't move with probability (1 - p), paralyzed by his fear of escalators and making the whole queue wait behind him.

Formally speaking, the i-th person in the queue cannot enter the escalator until people with indices from 1 to i - 1 inclusive enter it. In one second only one person can enter the escalator. The escalator is infinite, so if a person enters it, he never leaves it, that is he will be standing on the escalator at any following second. Ilya needs to count the expected value of the number of people standing on the escalator after t seconds.

Your task is to help him solve this complicated task.

Input
The first line of the input contains three numbers n, p, t (1 ≤ n, t ≤ 2000, 0 ≤ p ≤ 1). Numbers n and t are integers, number p is real, given with exactly two digits after the decimal point.

Output
Print a single real number — the expected number of people who will be standing on the escalator after t seconds. The absolute or relative error mustn't exceed 10 - 6.

Ex:
Input: 1 0.50 1
Output: 0.5
Explaination: at 1 sec either first person goes on elevator and there is 1 person at elevator or not and there are 0 person at elevator i.e, E(X)=1*0.50+0*(1-0.50)*/

import java.util.Scanner;

public class elevator {

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of steps on the escalator
        double p = scanner.nextDouble(); // probability of a person taking a step
        int t = scanner.nextInt(); // number of seconds
        double[][] dp = new double[t + 1][n + 1]; // DP array to store probabilities

        dp[0][0] = 1; // Base case: Initially, no one is on the escalator

        // Filling up the DP table
        for (int i = 1; i <= t; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - p); // Transition when there are no people on the escalator
            for (int j = 1; j <= n; j++) {
                if (j == n)
                    dp[i][j] = dp[i - 1][j - 1] * p + dp[i - 1][j]; // Transition when the escalator is full
                else
                    dp[i][j] = dp[i - 1][j - 1] * p + dp[i - 1][j] * (1 - p); // General transition
            }
        }

        // Calculating the final answer
        double ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += dp[t][i] * i;
        }
        System.out.printf("%.12f\n", ans); // printing the answer with precision
    }

    public static void main(String[] args) {
        solve();
    }
}

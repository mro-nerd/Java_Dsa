/*Taro has N items, each with a weight and a value. He wants to choose a subset of these items to carry home in a knapsack with a maximum weight capacity of W.
Your task is to determine the maximum total value Taro can carry without exceeding the knapsack's weight limit. 
(1<=W<=10^9)

EX:-
Input:
1 1000000000
1000000000 10

Output:
10*/

import java.util.*;

public class knapsackII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int W = scanner.nextInt();

        int[] values = new int[N];
        int[] weights = new int[N];
        int totalValue = 0;

        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
            totalValue += values[i];
        }

        long[] DP = new long[totalValue + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = totalValue; j >= values[i]; j--) {
                DP[j] = Math.min(DP[j], DP[j - values[i]] + weights[i]);
            }
        }

        int answer = 0;
        for (int i = 0; i <= totalValue; i++) {
            if (DP[i] <= W) {
                answer = i;
            }
        }

        System.out.println(answer);
    }
}


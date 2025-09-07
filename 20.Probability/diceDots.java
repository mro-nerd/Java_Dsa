/*Twilight Sparkle was playing Ludo with her friends Rainbow Dash, Apple Jack and Flutter Shy. But she kept losing. Having returned to the castle, Twilight Sparkle became interested in the dice that were used in the game.

The dice has m faces: the first face of the dice contains a dot, the second one contains two dots, and so on, the m-th face contains m dots. Twilight Sparkle is sure that when the dice is tossed, each face appears with probability 1/m. Also she knows that each toss is independent from others. Help her to calculate the expected maximum number of dots she could get after tossing the dice n times.

Input
A single line contains two integers m and n (1 ≤ m, n ≤ 105).

Output
Output a single real number corresponding to the expected maximum. The answer will be considered correct if its relative or absolute error doesn't exceed 10  - 4.

Example:-
Input:6 1
Output:3.500000000000

Input:6 3
Output:4.958333333333*/

import java.util.Scanner;

public class diceDots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double m = scanner.nextDouble();
        double n = scanner.nextDouble();
        double ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += i * (Math.pow(i / m, n) - Math.pow((i - 1) / m, n));
            //System.out.println(ans);
        }
        System.out.printf("%.5f\n", ans);
    }
}

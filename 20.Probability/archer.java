/*SmallR is an archer. SmallR is taking a match of archer with Zanoes. They try to shoot in the target in turns, and SmallR shoots first. The probability of shooting the target each time is a/b for SmallR while c/d for Zanoes. The one who shoots in the target first should be the winner.

Output the probability that SmallR will win the match.

Input
A single line contains four integers 1<=a,b,c,d<=1000.

Output
Print a single real number, the probability that SmallR will win the match.

The answer will be considered correct if the absolute or relative error doesn't exceed 10^-6. */

import java.util.*;

public final class archer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        double Wa = a/(double)b, Wb = c/(double)d;
        double La = 1.0 - Wa, Lb = 1.0 - Wb;
        double ans = Wa/(1.0 - La*Lb);
        System.out.println(ans);
    }
}
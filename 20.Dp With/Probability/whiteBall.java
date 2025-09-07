/*There are W white and B black balls in the box do following until there is only one ball left in box:
 
Pick any 2 balls from box if they are of same color then add a black ball to the box other wise add a white ball to the box.
Now return what is the probability that the one ball left in that box is white ball.
 */

import java.util.*;

public class whiteBall {
    static double dp[][];

    static int C2(int n) {
        if(n < 2)
            return 0;
        return n*(n-1)/2;
    }

    public static double probHelper(int w, int b) {
        if(w < 0 || b < 0)
            return 0.0;
        if(w == 0 && b == 1)
            return 0.0;
        if(w == 1 && b == 0)
            return 1.0;
        if(dp[w][b] != -1.0)
            return dp[w][b];

        double pb = C2(b) / (double) C2(w + b); // both black
        double pw = C2(w) / (double) C2(w + b); // both white
        double pbw = 1.0 - pb - pw; // 1 white & 1 black

        return dp[w][b] = pb * probHelper(w, b - 1) + pw*probHelper(w-2, b+1) + pbw * probHelper(w, b - 1);
    }

    public static void main(String[] args) {
        dp = new double[2001][2001];
        for(double row[] : dp)
            Arrays.fill(row, -1.0);

        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(probHelper(w, b));
    }
}
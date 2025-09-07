/*There are N dishes, numbered 1,2,…,N. Initially, for each i (1≤i≤N), Dish i has ai​  (1≤a i ≤3) pieces of sushi on it.
Taro will perform the following operation repeatedly until all the pieces of sushi are eaten:

->Roll a die that shows the numbers 1,2,…,N with equal probabilities, and let i be the outcome.
->If there are some pieces of sushi on Dish i, eat one of them.
->if there is none, do nothing.

Find the expected number of times the operation is performed before all the pieces of sushi are eaten.

Constraints
All values in input are integers.
1≤N≤300
1≤ai≤3
*/

import java.util.Arrays;
import java.util.Scanner;

public class sushiPlate {

    static int n;
    static final int maxN = 300;
    static double[][][] dp = new double[maxN + 1][maxN + 1][maxN + 1];
    static boolean[][][] vis = new boolean[maxN + 1][maxN + 1][maxN + 1];

    static double ev(int c1, int c2, int c3) {
        if (c1 == 0 && c2 == 0 && c3 == 0) return 0;
        if (vis[c1][c2][c3]) return dp[c1][c2][c3];
        double ans = 1;
        if (c1 > 0) ans += ((1.0) * c1 / n) * ev(c1 - 1, c2, c3);
        if (c2 > 0) ans += ((1.0) * c2 / n) * ev(c1 + 1, c2 - 1, c3);
        if (c3 > 0) ans += ((1.0) * c3 / n) * ev(c1, c2 + 1, c3 - 1);
        double p0 = ((1.0) * n - c1 - c2 - c3) / n;
        ans /= (1 - p0);
        vis[c1][c2][c3] = true;
        return dp[c1][c2][c3] = ans;
    }

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            cnt[x]++;
        }
        for (double[][] layer2D : dp)
            for (double[] layer1D : layer2D)
                Arrays.fill(layer1D, -1); // initializing dp array with -1
        System.out.printf("%.12f", ev(cnt[1], cnt[2], cnt[3]));
    }

    public static void main(String[] args) {
        solve();
    }
}

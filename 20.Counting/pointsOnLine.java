/*We want the number of triplets pointd (i, j, k) (with i < j < k<n) from n points such that:
𝑎[𝑘]−𝑎[𝑖]≤𝑑
Points are sorted, which is crucial. */

import java.util.*;

public class pointsOnLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long ans = 0;
        int r = 0;

        for (int l = 0; l < n; l++) {
            r = Math.max(r, l); // ensure r is never behind l
            while (r + 1 < n && a[r + 1] - a[l] <= d) {
                r++;
            }
            if (r - l + 1 >= 3) { // at least 3 points in the window
                long cur = r - l; // number of points to the right of l
                ans += cur * (cur - 1L) / 2; // choose 2 from them
            }
        }

        System.out.println(ans);
    }
}

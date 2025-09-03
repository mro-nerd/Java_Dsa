/*
Problem:
---------
We are given n sorted points on a line (array a[0..n-1]).
We want to count the number of triplets (i, j, k) with i < j < k < n
such that:

    a[k] - a[i] <= d   (the max distance in the triplet is at most d)

Key Observations:
-----------------
1. The array a[] is sorted.
   → So if a[r] - a[l] <= d, then ALL points between l and r
     also satisfy the condition with l as the left boundary.

2. For each fixed left index l:
   - Find the maximum index r such that a[r] - a[l] <= d.
   - Then, any two indices j, k with l < j < k <= r
     will form a valid triplet (i = l, j, k).
   - Count how many such pairs (j, k) exist.

3. Number of valid pairs (j, k) = Choose 2 out of (r - l) elements.
   Formula: C(r-l, 2) = (r-l) * (r-l-1) / 2

4. Use a sliding window / two pointers:
   - Increase r while condition holds.
   - Move l forward one by one.
   - r never moves backwards (O(n) total complexity).
*/

import java.util.*;

public class pointsOnLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // number of points
        int d = sc.nextInt();   // maximum allowed distance
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt(); // input points (sorted already)
        }

        long ans = 0; // final count of triplets
        int r = 0;    // right pointer

        // Iterate over each possible left index l
        for (int l = 0; l < n; l++) {
            // ensure r never moves backward
            r = Math.max(r, l);

            // extend r as far as possible while condition holds
            while (r + 1 < n && a[r + 1] - a[l] <= d) {
                r++;
            }

            // Now [l..r] is the largest valid segment with a[r]-a[l] <= d

            if (r - l + 1 >= 3) { 
                // We have at least 3 points in this window
                // (including l itself). Need to pick 2 more from the right.

                long cur = r - l; // number of points strictly to the right of l
                ans += cur * (cur - 1L) / 2; // choose any 2 out of them
            }
        }

        System.out.println(ans);
    }
}

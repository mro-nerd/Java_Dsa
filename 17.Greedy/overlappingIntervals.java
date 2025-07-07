/*Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.*/

import java.util.*;

public class overlappingIntervals {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                intervals[i][j] = scanner.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println(obj.eraseOverlapIntervals(intervals));
        scanner.close();
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int currEnd = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= currEnd) {
                currEnd = intervals[i][1];
            } else {
                currEnd = Math.min(currEnd, intervals[i][1]);
                ans++;
            }
        }
        return ans;
    }
}


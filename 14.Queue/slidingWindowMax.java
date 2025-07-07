/*An Int array arr is given and window of k length is sliding over it from left to right. Return an array ans which stores max element from each array.
 * 
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */


import java.util.*;

 class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        int ans[] = new int[n - k + 1];
        int ansId = 0;

        for (int i = 0; i < n; ++i) {
            // Remove elements out of the window from the front
            if (!q.isEmpty() && q.getFirst() <= i - k) {
                q.removeFirst();
            }

            // Remove elements from back while they are smaller than current element
            while (!q.isEmpty() && arr[q.getLast()] <= arr[i]) {
                q.removeLast();
            }

            // Add current element index
            q.addLast(i);

            // Start adding results once the first full window is processed
            if (i >= k - 1) {
                ans[ansId++] = arr[q.getFirst()];
            }
        }
        return ans;
    }
}

public class slidingWindowMax {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example test case
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        int[] result = solution.maxSlidingWindow(arr, k);
        
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result));
    }
}



/*Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.
Note: If a window does not contain a negative integer, then return 0 for that window.

Examples:
Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28] , k = 3
Output: [-1, -1, -7, -15, -15, 0] 
Explanation:
Window [12, -1, -7] First negative integer is -1.
Window [-1, -7, 8] First negative integer is -1.
Window [-7, 8, -15] First negative integer is -7.
Window [8, -15, 30] First negative integer is -15.
Window [-15, 30, 16] First negative integer is -15.
Window [30, 16, 28] No negative integers, output is 0.
*/

import java.util.*;

class Compute {

    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        List<Long> ans = new ArrayList<>();
        Queue<Long> neg = new LinkedList<>();
        int j;

        // Adding negative numbers in a queue for the first window
        for (j = 0; j < K; j++) {
            if (A[j] < 0)
                neg.offer(A[j]);
        }

        // For the first window, if there is no negative number, store 0 as answer; otherwise
        // store the first negative number as answer, which is queue's first element
        if (!neg.isEmpty())
            ans.add(neg.peek());
        else
            ans.add(0L);

        // Now checking for other possible windows    
        for (j = K; j < N; j++) {
            // As we slide the window, we have to make sure that if the previous first number is 
            // negative, then remove it from the queue
            if (A[j - K] < 0) {
                neg.poll();
            }

            // If new number occurring in a window is negative, then add it to the queue
            if (A[j] < 0)
                neg.offer(A[j]);

            // Store answer for the current window
            if (!neg.isEmpty())
                ans.add(neg.peek());
            else
                ans.add(0L);
        }

        // Convert list to array
        long[] result = new long[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}

public class firstNegative {
    public static void main(String[] args) {
        // Example input
        long[] array = {12, -1, -7, 8, 15, 30, 16, 28};
        int n = array.length;
        int k = 3;
        Compute compute = new Compute();
        long[] result = compute.printFirstNegativeInteger(array, n, k);

        // Print the results
        System.out.println("First negative integers in each window:");
        for (long num : result) {
            System.out.print(num + " ");
        }
    }
}



/*Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17. */

import java.util.Stack;

public class sumOfSubarrayMins {
    public static  int sumSubarrayMins(int[] A) {
        int n = A.length;
        int MOD = (int) (1e9 + 7);
        int[] left = new int[n];
        int[] right = new int[n];

        // Left
        Stack<Integer> st = new Stack<>();
        st.push(0);
        left[0] = 1; // distance = 1, left not found, this is distance multiplied with num, so it can't be zero
        for (int i = 1; i < n; i++) {
            while (!st.empty() && A[i] < A[st.peek()])
                st.pop();

            if (st.empty())
                left[i] = i + 1; // total distance if less element not found = i+1
            else
                left[i] = i - st.peek(); // distance = i-st.top()

            st.push(i);
        }

        st.clear();

        // Right
        st.push(n - 1);
        right[n - 1] = 1; // distance = 1, right not found, this is distance multiplied with num, so it can't be zero
        for (int i = n - 2; i >= 0; i--) {
            while (!st.empty() && A[i] <= A[st.peek()])
                st.pop();

            if (st.empty())
                right[i] = n - i; // distance
            else
                right[i] = st.peek() - i;

            st.push(i);
        }

        // for each i, contribution is (Left * Right) * Element
        long res = 0;
        for (int i = 0; i < n; i++) {
            long prod = ((long) left[i] * right[i]) % MOD;
            prod = (prod * A[i]) % MOD;
            res = (res + prod) % MOD;
        }

        return (int) (res % MOD);
    }

    public static void main(String[] args) {
        
        int[] A = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(A)); // Output: 17
    }
}

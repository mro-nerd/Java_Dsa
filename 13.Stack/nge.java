/*Given an array arr[ ] of integers, the task is to find the next greater element for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1. */

import java.util.*;

class Solution {
    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> s = new Stack<>();
        long ans[] = new long[n];
        for (int i = n - 1; i >= 0; --i) {
            while (s.empty() == false && s.peek() <= arr[i])
                s.pop();
            ans[i] = s.empty() == true ? -1 : s.peek();
            s.push(arr[i]);
        }
        return ans;
    }
}

public class nge {
 


    public static void main(String[] args) {
        // Test the nextLargerElement function
        long[] arr = {85,75,60,70,60,80,100}; // Example array
        int n = arr.length;
        
        long[] result = Solution.nextLargerElement(arr, n);
        
        // Print the results
        System.out.println("The Next Greater Elements are:");
        for (long res : result) {
            System.out.print(res + " ");
        }
    }


}

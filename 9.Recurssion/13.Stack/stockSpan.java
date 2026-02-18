/*The stock span problem is a financial problem where we have a series of daily price quotes for a stock denoted by an array arr[] and the task is to calculate the span of the stock’s price for all days. The span arr[i] of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.
 
Input: arr[] = [100, 80, 60, 70, 60, 75, 85]
Output: [1, 1, 1, 2, 1, 4, 6]
Explanation: Traversing the given input span 100 is greater than equal to 100 and there are no more elements behind it so the span is 1, 80 is greater than equal to 80 and smaller than 100 so the span is 1, 60 is greater than equal to 60 and smaller than 80 so the span is 1, 70 is greater than equal to 60,70 and smaller than 80 so the span is 2 and so on.  Hence the output will be 1 1 1 2 1 4 6.
 */

import java.util.*;

class Solution {
    static int[] prevGreaterElements(int nums[], int n) {
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[n];

        for (int i = 0; i < n; ++i) {
            while (!s.empty() && nums[s.peek()] <= nums[i])
                s.pop();

            ans[i] = s.empty() ? -1 : s.peek();
            s.push(i);
        }

        return ans;
    }

    // Function to calculate the span of stock's price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        int pge[] = prevGreaterElements(price, n);
        int ans[] = new int[n];

        for (int i = 0; i < n; ++i)
            ans[i] = i - pge[i];

        return ans;
    }
}

public class stockSpan{
    public static void main(String[] args) {
        // Test the calculateSpan function
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        int n = price.length;

        int[] result = Solution.calculateSpan(price, n);

        // Print the results
        System.out.println("The stock spans are:");
        for (int res : result) {
            System.out.print(res + " ");
        }
    }

}
/*You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7. */

public class buySellStocks {
   
    static int getMaximumProfit(int[] Arr, int n) {
        // Create a 2D array for dynamic programming with dimensions [n+1][2]
        int[] ahead = new int[2];
        int[] cur = new int[2];

        // Base condition: If we have no stocks to buy or sell, profit is 0
        ahead[0] = ahead[1] = 0;

        int profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], Arr[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }

            // Update the 'ahead' array with the current profit values
            System.arraycopy(cur, 0, ahead, 0, 2);
        }
        return cur[0]; // The maximum profit is stored in 'cur[0]'
    }
    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        int ans=getMaximumProfit(arr, arr.length);
        System.out.println(ans);
    }
}


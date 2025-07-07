/*You are given an array of positive integers price where price[i] denotes the price of the ith candy and a positive integer k.
The store sells baskets of k distinct candies. The tastiness of a candy basket is the smallest absolute difference of the prices of any two candies in the basket.

Return the maximum tastiness of a candy basket.

ex:

Input: price = [13,5,1,8,21,2], k = 3
Output: 8
Explanation: Choose the candies with the prices [13,5,21].
The tastiness of the candy basket is: min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8.
It can be proven that 8 is the maximum tastiness that can be achieved. */

import java.util.Arrays;

public class maxTastiness {
    public static void main(String[] args) {
        int price[]={13,5,1,8,21,2};
        int k =3;
        System.out.println(maximumTastiness(price, k));
    }
    
    public static boolean isPossible(int mid, int[] price, int k) {
        int previous = price[0];
        int count = 1;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - previous >= mid) {
                count++;
                previous = price[i];
            }
        }

        return count >= k;
    }

    public static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int ans = 0;
        int n = price.length;
        int st = 0, ed = price[n - 1] - price[0];

        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (isPossible(mid, price, k)) {
                ans = mid;
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }

        return ans;
    }
}

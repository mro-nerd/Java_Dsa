/*You are given an integer array bloomDay, an integer m and an integer k.You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1. 

ex:
Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways.
*/

public class makeBouquets {
    public static void main(String[] args) {
        int bloomDay[]={7,7,7,7,12,7,7};
        int m=2;
        int k=3;
        System.out.println(minDays(bloomDay, m, k));
    }
    public static int countBouquet(int[] bloomDay, int k, int day) {
        int bouquets = 0, flowers = 0;
        for (int x : bloomDay) {
            if (x <= day) {
                flowers++;
            } else {
                flowers = 0;
            }

            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }
        }

        return bouquets;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        long n = bloomDay.length;
        long total = (long) m * (long) k;
        if (n < total) {
            return -1;
        }
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, ans=-1,day;
        for(int b:bloomDay){
            left=Math.min(left,b);
            right=Math.max(right,b);
        }

        

        while (left<= right) {
            day = left+(right-left) / 2;
            if (countBouquet(bloomDay, k, day) < m) {
                left = day+1;
            } else {
                right = day-1;
                ans=day;
            }
        }
      return ans;
    }
}

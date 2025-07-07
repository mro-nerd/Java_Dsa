/*A conveyor belt has packages that must be shipped from one port to another within days days.
The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days. 

ex:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10
*/

public class shipInDays {
    public static int maxValue(int w[]) {
        int ans = 0;
        for(int num : w)
            ans = Math.max(ans, num);
        return ans;
    }
    public static int sumOfValues(int w[]) {
        int sum = 0;
        for(int num : w)
            sum += num;
        return sum;
    }

    public static int minDaysReq(int[] w, int cap) {
        int curDay = 1, curLoad = 0;

        for(int item : w) {
            if(curLoad + item <= cap)
                curLoad += item;
            else {
                curDay += 1;
                curLoad = item;
            }
        }

        return curDay;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int beg = maxValue(weights), end = sumOfValues(weights), minCap = -1;
        while(beg <= end) {
            int midCap = beg+(end-beg)/2;
            if(minDaysReq(weights, midCap) <= days) {
                minCap = midCap;
                end = midCap - 1;
            }
            else {
                beg = midCap + 1;
            }
        }
        return minCap;
    }
    public static void main(String[] args) {
        int weights[]={1,2,3,4,5,6,7,8,9,10};
        int days=5;
        System.out.println(shipWithinDays(weights, days));
    }
}

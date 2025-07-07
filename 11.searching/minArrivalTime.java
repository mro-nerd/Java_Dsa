/*You are given a floating-point number hour, representing the amount of time you have to reach the office. To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n, where dist[i] describes the distance (in kilometers) of the ith train ride.

Each train can only depart at an integer hour, so you may need to wait in between each train ride.

For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.

Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time, or -1 if it is impossible to be on time. 

ex:
Input: dist = [1,3,2], hour = 2.7
Output: 3
Explanation: At speed 3:
- The first train ride takes 1/3 = 0.33333 hours.
- Since we are not at an integer hour, we wait until the 1 hour mark to depart. The second train ride takes 3/3 = 1 hour.
- Since we are already at an integer hour, we depart immediately at the 2 hour mark. The third train takes 2/3 = 0.66667 hours.
- You will arrive at the 2.66667 hour mark.
*/
public class minArrivalTime {
    public static void main(String[] args) {
        int dist[]={1,3,2};
        double hr=2.7;
        System.out.println(minSpeedOnTime(dist, hr));
    }

    public static boolean isPossible(int[] dist, int speed, double hour) {
        double ans = 0;
        int n = dist.length;
        for (int i = 0; i < n - 1; i++) {
            if (dist[i] % speed == 0) {
                ans += dist[i] / speed;
            } else {
                ans += (dist[i] / speed) + 1;
            }
        }
        ans += (double) dist[n - 1] / speed;
        return ans <= hour;
    }
    
    public static int minSpeedOnTime(int[] dist, double hour) {
        int st = 1, ed = 10000001;
        int ans = -1;
        
        while (st <= ed) {
            int mid = (st + ed) / 2;
            
            if (isPossible(dist, mid, hour)) {
                ans = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        
        return ans;
    }
}

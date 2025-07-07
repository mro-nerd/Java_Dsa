/*You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.

Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.

You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips. 

ex:-

Input: time = [1,2,3], totalTrips = 5
Output: 3
Explanation:
- At time t = 1, the number of trips completed by each bus are [1,0,0]. 
  The total number of trips completed is 1 + 0 + 0 = 1.
- At time t = 2, the number of trips completed by each bus are [2,1,0]. 
  The total number of trips completed is 2 + 1 + 0 = 3.
- At time t = 3, the number of trips completed by each bus are [3,1,1]. 
  The total number of trips completed is 3 + 1 + 1 = 5.
So the minimum time needed for all buses to complete at least 5 trips is 3.

*/
public class minTrips {
    public static void main(String[] args) {
        int time[]={1,2,3};
        int totalTrips=5;
        System.out.println(minimumTime(time, totalTrips));

    }
    public static boolean isPossible(long mid, int totalTrips, int[] time) {
        long ct = 0;
        for (int i = 0; i < time.length; i++) {
            ct += mid / time[i];
        }
        return ct >= totalTrips;
    }

    public static long minimumTime(int[] time, int totalTrips) {
        long st = 0, ed = (time[0] + 0L) * totalTrips;
        long ans = 0;
        while (st <= ed) {
            long mid = (st + ed) / 2;

            if (isPossible(mid, totalTrips, time)) {
                ans = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }    
}

/*You are given an integer array ranks representing the ranks of some mechanics. ranks(i) is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.
You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
Return the minimum time taken to repair all the cars.

Note: All the mechanics can repair the cars simultaneously. 

ex:
Input: ranks = [4,2,3,1], cars = 10
Output: 16
Explanation: 
- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
- The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
- The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
- The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
*/

public class carRepair {
   public static void main(String[] args) {
    int ranks[]={4,2,3,1};
    int cars=10;
    System.out.println(repairCars(ranks, cars));
   }
    public static boolean isPossible(long mid, int[] ranks, int cars) {
        long car = 0;
        for (int r : ranks) {
            long rem = (mid / r);
            car += Math.sqrt(rem);
        }
        return car >= cars;
    }

    public static long repairCars(int[] ranks, int cars) {
        int maxRank = Integer.MIN_VALUE;
       for (int rank : ranks) {
           if (rank > maxRank) {
               maxRank = rank;
           }
       }
        long ans = 0;
        long st = 0, ed = maxRank * (long) cars * cars;

        while (st <= ed) {
            long mid = st+(ed-st) / 2;

            if (isPossible(mid, ranks, cars)) {
                ans = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }
}

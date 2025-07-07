/*Our chef has recently opened a new restaurant with a unique style. The restaurant is divided into K compartments (numbered from 1 to K) and each compartment can be occupied by at most one customer.

Each customer that visits the restaurant has a strongly preferred compartment p (1 ≤ p ≤ K), and if that compartment is already occupied, then the customer simply leaves. Now obviously, the chef wants to maximize the total number of customers that dine at his restaurant and so he allows (or disallows) certain customers so as to achieve this task. You are to help him with this.

Given a list of N customers with their arrival time, departure time and the preferred compartment, you need to calculate the maximum number of customers that can dine at the restaurant.

Input
The first line contains an integer T denoting the number of test cases. Each of the next T lines contains two integers N and K , the number of customers that plan to visit the chef's restaurant and the number of compartments the restaurant is divided into respectively. Each of the next N lines contains three integers si, fi and pi , the arrival time, departure time and the strongly preferred compartment of the ith customer respectively.
Note that the ith customer wants to occupy the pith compartment from [si, fi) i.e the ith customer leaves just before fi so that another customer can occupy that compartment from fi onwards.

Output
For every test case, print in a single line the maximum number of customers that dine at the restaurant.

Example:

Input:
1
4 2
10 100 1
100 200 2
150 500 2
200 300 2

Outtput:
3*/

import java.util.*;

public class restaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int f = scanner.nextInt();
            int p = scanner.nextInt() - 1;
            if (!map.containsKey(p)) {
                map.put(p, new ArrayList<>());
            }
            map.get(p).add(new int[]{s, f});
        }
        int ans = 0;
        for (List<int[]> intervals : map.values()) {
            Collections.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
            int currEnd = -1;
            for (int[] interval : intervals) {
                if (interval[0] >= currEnd) {
                    ans++;
                    currEnd = interval[1];
                } else {
                    currEnd = Math.min(currEnd, interval[1]);
                }
            }
        }
        System.out.println(ans);
    }
}

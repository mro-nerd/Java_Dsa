/*The subcommittee members are asked to go to food connection and get P (P<=1000) pratas packed for the function. The stall has L cooks (L<=50) and each cook has a rank R (1<=R<=8). A cook with a rank R can cook 1 prata in the first R minutes 1 more prata in the next 2R minutes, 1 more prata in 3R minutes and so on (he can only cook a complete prata) (For example if a cook is ranked 2, he will cook one prata in 2 minutes one more prata in the next 4 mins an one more in the next 6 minutes hence in total 12 minutes he cooks 3 pratas in 13 minutes also he can cook only 3 pratas as he does not have enough time for the 4th prata). The webmaster wants to know the minimum time to get the order done. Please write a program to help him out.

Input
The first line tells the number of test cases. Each test case consist of 2 lines. In the first line of the test case we have P the number of prata ordered. In the next line the first integer denotes the number of cooks L and L integers follow in the same line each denoting the rank of a cook.

Output
Print an integer which tells the number of minutes needed to get the order done. */

import java.util.Scanner;

public class parata {
    
    static long maxByCook(long rank, long time_allowed) {
        long beg = 0, end = time_allowed, ans = -1;

        while (beg <= end) //Binary Searching for max. number of paratas possible to be cooked within t seconds
        {
            long mid = (beg + end) / 2;

            long time_for_mid = (rank * (mid + 1) * mid) / 2; //4 * (4e6) * (4e6) -> 6.4e13

            if (time_for_mid <= time_allowed) {
                ans = mid;
                beg = mid + 1;
            }

            else
                end = mid - 1;
        }

        return ans;
    }

    static long maxParatas(long t, long r[], long n)
    {
        long total_paratas = 0;

        for (int i = 0; i < n; ++i)
            total_paratas += maxByCook(r[i], t);

        return total_paratas;
    }
    public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while(t-- > 0)
        {
            long p = sc.nextLong();
            int n = sc.nextInt();
            long r[] = new long[n];

            for (int i = 0; i < n; ++i)
                r[i] = sc.nextLong();

            sc.close();
            long beg = 0, end = (r[0] * p * (p + 1)) / 2, ans = -1;

            while (beg <= end) //binary search for minimum reqd time
            {
                long mid = (beg + end) / 2;

                if (maxParatas(mid, r, n) >= p) {
                    ans = mid;
                    end = mid - 1;
                }
                else
                    beg = mid + 1;
            }

            System.out.println(ans);
        }
	}
}

/*We need to count the number of arrays of length n such that:
->Each element is between l and r (inclusive).
->The sum of the array is divisible by 3.
->Answer must be given modulo 1e9+7. 
Ex:
Input:
2 1 3
Output:
3
Explaination:Valid arrays would be, [1,2] ,[2,1], [3,3]
*/

import java.util.*;

public final class lostArray {
	static final long mod = 1000000007;
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long l = sc.nextLong();
		long r = sc.nextLong();

		long zeroCnt = r/3 - (l-1)/3;
		long oneCnt = l > 1 ? (r-1)/3 - (l-2)/3 : 1 + (r-1)/3;
		long twoCnt = (r-l+1) - zeroCnt - oneCnt;
		
		long dp[][] = new long[n+1][3];

		dp[1][0] = zeroCnt;
		dp[1][1] = oneCnt;
		dp[1][2] = twoCnt;

		for(int i = 2; i <= n; ++i) {
			for(int j = 0; j <= 2; ++j) {
				// 1st number is a multiple of 3.
				long poss1 = (zeroCnt * dp[i-1][j]) % mod;

				// 1st number % 3 => 1
				long poss2 = (oneCnt * dp[i-1][(j+2)%3]) % mod;

				// 1st number % 3 => 2
				long poss3 = (twoCnt * dp[i-1][(j+1)%3]) % mod;

				dp[i][j] = (poss1 + poss2 + poss3) % mod;
			}
		}

		System.out.println(dp[n][0]);
    }
}
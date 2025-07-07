/*Appy loves balloons! She wants you to give her balloons on each of N consecutive days (numbered 1 through N); let's denote the number of balloons Appy wants on day i by A (i)
​The problem is that you only have M balloons. Fortunately, you can give her candies instead of balloons as well. On each day i, Appy accepts B (i) candies per each balloon you do not give her — formally, if you give Appy X(i) balloons on day 
i, then you have to give her 
𝐶𝑖=max(0,𝐴𝑖−𝑋𝑖)⋅𝐵𝑖 candies as well.

Your task is to minimize the maximum number of candies you give Appy on some day — find the minimum possible value of 

max(C 1,C 2,C 3,...,C N). 

first input line is for N M
2nd is for the elements of array A
3rd is for elements of array B

ex:

input=>

5 3 
1 2 3 4 5
1 2 3 4 5

output =>

15 

Explanation:
If you give Appy 
0,0,0,1,2 balloons on days 1 through 5, then the required numbers of candies on each day are 
1,4,9,12,15. The maximum number of candies is 15, required on day 5.*/


import java.util.Scanner;

public class appyAndBalloons {
    public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        
        int a[] = new int[n];
        int b[] = new int[n];
        
        for(int i = 0; i < n; ++i)
            a[i] = sc.nextInt();
            
        for(int i = 0; i < n; ++i)
            b[i] = sc.nextInt();
         
       sc.close();     
        System.out.println(getMinCandies(a , b , m));    

	}
	 public static long minBalloonsReq(int a[], int b[], long maxCandies) {
        long ans = 0;
        for(int i = 0; i < a.length; ++i) {
            if(b[i] == 0)
                continue;
            ans += Math.max(0, a[i] - maxCandies/b[i]);
        }
        return ans;
    }

    public static long getMinCandies(int[] a, int[] b, long balloonLimit) {
        long beg = 0, end = (long)1e18, ans = -1;
        while(beg <= end) {
            long mid = (beg + end)/2;
            if(minBalloonsReq(a, b, mid) <= balloonLimit) {
                ans = mid;
                end = mid - 1;
            }
            else {
                beg = mid + 1;
            }
        }
        return ans;
    }
}

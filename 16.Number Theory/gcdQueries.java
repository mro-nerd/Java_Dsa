/*You are given an array A of integers of size N. You will be given Q queries where each query is represented by two integers L, R. You have to find the gcd(Greatest Common Divisor) of the array after excluding the part from range L to R inclusive (1 Based indexing). You are guaranteed that after excluding the part of the array remaining array is non empty.

Input
First line of input contains an integer T denoting number of test cases.
For each test case, first line will contain two space separated integers N, Q.
Next line contains N space separated integers denoting array A.
For next Q lines, each line will contain a query denoted by two space separated integers L, R.

Output
For each query, print a single integer representing the answer of that query.

Example 1:

Input:
1
4 1
2 6 9 5
2 3

Output:
1*/

import java.util.*;

public class gcdQueries {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
			int q = scanner.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}
			int[] preGcd = new int[n + 1];
			int[] sufGcd = new int[n + 1];
			for (int i = 0; i < n; i++) {
				preGcd[i + 1] = gcd(preGcd[i], arr[i]);
			}
			for (int i = n - 1; i >= 0; i--) {
				sufGcd[i] = gcd(sufGcd[i + 1], arr[i]);
			}
			while (q-- > 0) {
				int l = scanner.nextInt();
				int r = scanner.nextInt();
				System.out.println(gcd(preGcd[l - 1], sufGcd[r]));
			}
        }
        scanner.close();
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}

/*You are given an array of n positive integers. Your task is to find two integers such that their greatest common divisor is as large as possible.

Example
Input:

5
3 14 15 7 9
Output:
7
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class commonDivisor {

    public static void main(String[] args) throws Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        String arr[] = r.readLine().split(" ");

        int maxVal = 0;
        int[] input = new int[n];

        // Step 1: Read input and find max value
        for (int i = 0; i < n; ++i) {
            input[i] = Integer.parseInt(arr[i]);
            maxVal = Math.max(maxVal, input[i]);
        }

        // Step 2: Frequency array sized to maxVal
        int freq[] = new int[maxVal + 1];
        for (int i = 0; i < n; ++i) {
            freq[input[i]] += 1;
        }

        // Step 3: Main logic, but only up to maxVal
        int ans = -1;
        for (int gcd = maxVal; gcd >= 1; --gcd) {
            int cnt = 0;
            for (int num = gcd; num <= maxVal; num += gcd) {
                cnt += freq[num];
            }
            if (cnt >= 2) {
                ans = gcd;
                break;
            }
        }

        w.println(ans);
        w.flush();
    }
}


    


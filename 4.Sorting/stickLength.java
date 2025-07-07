/*There are n sticks with some lengths. Your task is to modify the sticks so that each stick has the same length.
You can either lengthen and shorten each stick. Both operations cost x where x is the difference between the new and original length.
What is the minimum total cost? 

The first input line contains an integer n: the number of sticks.
Then there are n integers: p1,p2,…,pn : the lengths of the sticks.*/

import java.util.Arrays;
import java.util.Scanner;

public class stickLength {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int arr[] = new int[n];
 
        long totalSum = 0;
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }
 
        Arrays.sort(arr);
 
        long leftSum = 0, finalAns = Long.MAX_VALUE;
        long leftCnt = 0, rightCnt = n;
        for(int i = 0; i < n; ++i) {
 
            // leftSum = sum(arr[0] ... arr[i])
            leftSum += arr[i];
 
            // leftCnt = count(0 ... i)
            leftCnt += 1;
 
            // rightSum = sum(arr[i+1] ... arr[n-1])
            long rightSum = totalSum - leftSum;
 
            // rightCnt = count(i+1 ... n-1)
            rightCnt -= 1;
 
 
            // Calculate current ans
            long curAns = (leftCnt*arr[i] - leftSum) + (rightSum - rightCnt*arr[i]);
            finalAns = Math.min(finalAns, curAns);
        }
 
        System.out.println(finalAns);
        sc.close();
    }
}

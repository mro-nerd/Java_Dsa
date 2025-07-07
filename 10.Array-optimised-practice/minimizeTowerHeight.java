/*Given an array arr[] denoting heights of N towers and a positive integer K.
For each tower, you must perform exactly one of the following operations exactly once.

Increase the height of the tower by K
Decrease the height of the tower by K

Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.
It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers. */

import java.util.Arrays;

public class minimizeTowerHeight {
    public static void main(String[] args){
        int arr[]={3,9,12,16,20};
        int k=3;
        int n=5;
        System.out.println(getMinDiff(arr,n, k));
    }
    public static int getMinDiff(int[] arr, int n, int k) {
       Arrays.sort(arr);
       int ans=arr[n-1]-arr[0];
       int smallest=arr[0]+k;
       int largest =arr[n-1]-k;
       for(int i=0;i<n-1;i++){
           int min=Math.min(smallest,arr[i+1]-k);
           int max=Math.max(largest,arr[i]+k);
           if(min<0)continue;
           ans=Math.min(ans,max-min);
       }
       return ans;
    }
}

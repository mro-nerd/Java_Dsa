/*Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j. 

ex: Input: n = 5, arr[] = {2, 4, 1, 3, 5}  Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).*/

import java.util.*;

public class inversionCount {
 
    public static void main(String[] args) {
       long arr[]={1,20,6,4,5};
       long N =5;
       System.out.println(inversionCounts(arr, N));
    }




   public static long mergeAndCount(long arr[], long left[], long right[]) {
        int i = 0, j = 0, k = 0;
        long ans = 0;
        
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                ans += left.length - i; // add appropriate value to ans;
                arr[k++] = right[j++];
            }
        }
        
        while(i < left.length)
            arr[k++] = left[i++];
            
        while(j < right.length)
            arr[k++] = right[j++];
            
        return ans;
    }
    
   public  static long inversionCounts(long arr[], long N)
    {
        if(N == 1)
            return 0;
        
        long left[] = Arrays.copyOfRange(arr, 0, (int)N/2);
        long right[] = Arrays.copyOfRange(arr, (int)N/2, (int)N);
        
        return inversionCounts(left, left.length) + inversionCounts(right, right.length) + mergeAndCount(arr, left, right);
    }

}

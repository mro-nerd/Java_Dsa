/*# find the max sum of elements of sub array of size from array a */


//here we can use sliding window for optimisation
public class maxSumSubarray {
    public static void main(String[] args) {
        int a[]={1,23,4,5,6,67,45,78,9,0};
        int k =2;
        System.out.println(maxSumSubarr(a,k));

    }
    public static int maxSumSubarr(int a[] , int k ){
        int n = a.length;
        int currSum = 0;
        for(int i = 0; i < k; i++){
            currSum += a[i]; //getting sum of 1st sub array
        }
        int finalAns = currSum;
        for(int start= 1,  end = k ; end<n ;start++,end++) {
            currSum -= a[start-1]; //finding sum of next subarray (window) via sum of first/prev sub array
            currSum += a[end];
          finalAns = Math.max(finalAns,currSum);

        }
        return finalAns;
    }
}

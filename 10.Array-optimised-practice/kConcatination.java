/*Given an integer array arr and an integer k, modify the array by repeating it k times.
For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
As the answer can be very large, return the answer modulo 10^9 + 7. */

public class kConcatination {
    public static void main(String[] args){
        int nums[]={1,-2,1};
        int k=5;
        System.err.println(kConcatenationMaxSum(nums, k));
    }
    public static int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        int mod = 1000000007; // To avoid overflow issues and as required by the problem constraints
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // Case when k == 1
        if (k == 1) {
            return (int) (kadane(arr) % mod);
        }
        // Case when sum is non-positive
        if (sum <= 0) {
            return (int) (kadanetwo(arr) % mod);
        }
        // Case when sum is positive
        return (int) ((kadanetwo(arr) + (k - 2) * sum) % mod);
    }

    public static int kadane(int[] arr) {
        int curr = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            curr = Math.max(curr + arr[i], arr[i]);
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }

    public static  int kadanetwo(int[] arr) {
        int n = arr.length;
        int[] narr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            narr[i] = arr[i];
            narr[i + n] = arr[i];
        }
        return kadane(narr);
    }
}

// # Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.Return the shortest such subarray and output its length.

import java.util.Scanner;

public class unsortedSubarray {



    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Input for N and K
        int N = sc.nextInt();

        // Input for the array
        int arr[] = new int[N];
        for(int i = 0; i < arr.length; ++i)
            arr[i] = sc.nextInt();

        sc.close();

        System.out.println(findUnsortedSubarray(arr));

    }

// Time: O(N^2)
// Space: O(1)


    public static int findUnsortedSubarray(int[] nums) {

        int n = nums.length;

        boolean pre[] = new boolean[n];
        boolean suf[] = new boolean[n];

        pre[0] = true;
        for(int i = 1; i < n; ++i)
            pre[i] = pre[i-1] && (nums[i] >= nums[i-1]);

        suf[n - 1] = true;
        for(int i = n - 2; i >= 0; --i)
            suf[i] = suf[i+1] && (nums[i] <= nums[i+1]);

        // Check for different subarrays now
        int ans = n;
        for(int i = 0; i < n; ++i) {
            int max_val = Integer.MIN_VALUE;
            int min_val = Integer.MAX_VALUE;
            for(int j = i; j < n; ++j) {
                max_val = Math.max(max_val, nums[j]);
                min_val = Math.min(min_val, nums[j]);

                boolean canSort = true;

                if(i > 0 && (pre[i-1] == false || min_val < nums[i-1]))
                    canSort = false;
                
                if(j < n - 1 && (suf[j+1] == false || max_val > nums[j+1]))
                    canSort = false;

                if(canSort) 
                    ans = Math.min(ans, j - i + 1);
            }
        }

        return ans == 1? 0 : ans;
    }
}

//!OR

// Yes, you can solve this in O(n) time. One common approach is to do a single left-to-right pass and a single right-to-left pass. For example, in the left-to-right pass, maintain the maximum seen so far and whenever the current element is less than that maximum, update a right boundary. In the right-to-left pass, maintain the minimum seen so far and whenever the current element is greater than that minimum, update a left boundary. Finally, the length of the unsorted subarray is right - left + 1 (or 0 if the array is already sorted).

// Below is an example O(n) solution:

// public static int findUnsortedSubarray(int[] nums) {
//     int n = nums.length;
//     int left = -1, right = -1;
    
//     int maxSeen = nums[0];
//     for (int i = 1; i < n; i++) {
//         maxSeen = Math.max(maxSeen, nums[i]);
//         if (nums[i] < maxSeen) {
//             right = i;
//         }
//     }
    
//     int minSeen = nums[n - 1];
//     for (int i = n - 2; i >= 0; i--) {
//         minSeen = Math.min(minSeen, nums[i]);
//         if (nums[i] > minSeen) {
//             left = i;
//         }
//     }
    
//     return right == -1 ? 0 : right - left + 1;
// }
// This solution works by first determining the rightmost index where an element is less than the maximum seen so far (indicating a drop in the sorted order) and then the leftmost index where an element is greater than the minimum seen from the right side. Sorting the subarray between these two indices will result in the entire array being sorted.


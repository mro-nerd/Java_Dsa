/*Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays. */



/*There is also one simple and  a little bit less optimized way where we convert this array in binary by nus[i]%2 (odds will become 1 and evens will become 0 ,after this it becomes binary sum subarray problem and get result by doing atMost(k)-atMost(k-1) 
 * although this approach is more optimized.
 */

import java.util.ArrayList;
import java.util.List;

public class niceSubarray {
    public static void main(String[] args){
        int nums[] = {1,1,2,1,1}; 
        int k = 3;
        System.out.println(numberOfNiceSubarrays(nums, k));
    }
    public static  int numberOfNiceSubarrays(int[] nums, int k) {
        List<Integer> even = new ArrayList<>();
        int temp = 0, ans = 0; 
        
        // Store Evens between odds
        for(int num : nums) {
            if(num % 2 == 0)
                temp++;
            else {
                even.add(temp);
                temp = 0; 
            }
        }
        even.add(temp); 
        
        int m = even.size();
        
        // sliding window to count number of subarrays
        for(int i = 0; i < m - k; i++) {
            ans += (even.get(i) + 1) * (even.get(i + k) + 1);//PnC formula for calculating number of possible sub array
        }
        
        return ans; 
    }

}

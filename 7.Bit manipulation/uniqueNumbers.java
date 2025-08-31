/*Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs whereas only two number occur exactly once and are distinct. Find the other two numbers. Return the answer in increasing order.

Examples:

Input: arr[] = [1, 2, 3, 2, 1, 4]
Output: [3, 4] 
Explanation: 3 and 4 occur exactly once. */

public class uniqueNumbers
{
    public static int[] singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        //System.out.println("before "+res);
        res -= (res&(res-1));
        //System.out.println("after "+res);
        
        int a = 0, b = 0;
        
        for(int num : nums)
            if((num&res) > 0)
                a ^= num;
            else
                b ^= num;
                
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return new int[]{a, b};
    }
    public static void main(String[] args) {
        int arr[]={4,1,2,1,2,3};
        int ans[]=singleNumber(arr);
        for(int i:ans){
            System.out.println(i);
        }
    }
}
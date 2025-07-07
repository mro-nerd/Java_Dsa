/*A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AP {
    public static void main(String[] args){
        int nums[]={4,6,5,9,3,7};
        int l[]={0,0,2};
        int r[]={2,3,5};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }
     public static  List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        ArrayList<Boolean> ans=new ArrayList<>();
        for(int i =0;i<l.length;i++){
           int[] subarray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            ans.add(check(subarray));
        }
        return ans;
    }
    public static boolean check(int[] nums){
        Arrays.sort(nums);
        int diff=nums[1]-nums[0];
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]!=diff){
                return false;
            }
               
        }
     return true;

    }
}

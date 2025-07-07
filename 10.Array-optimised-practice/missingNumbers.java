// #Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

import java.util.ArrayList;
import java.util.List;

public class missingNumbers {
    public static void main(String[] args) {
        int nums[]={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer>ans=new ArrayList<Integer>();
        int i =0;
        int n=nums.length;
        while(i<n){
            int index = nums[i]-1;
            if(nums[i]!=nums[index]){
                swap(nums,i,index);
            }
            else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                ans.add(j+1);
            }
        }
        return ans;
    }
    public static void swap(int[]nums , int i , int index){
         int temp=nums[i];
         nums[i]=nums[index];
         nums[index]=temp;
    }
}

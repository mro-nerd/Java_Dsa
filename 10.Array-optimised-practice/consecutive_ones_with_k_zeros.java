// # give the max number of consecutive 1's in a binary array nums[] such that k number of 0's kan be included at most 

public class consecutive_ones_with_k_zeros {
    public static void main(String[] args){
     
        int nums[]={0,0,0,1,0,1,0,1,1,1};
        int k=3;
        System.out.println(longestOnes(nums,k));
    }
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l =0 , ans =0 , zero_count=0;
        for(int r =0;r<n;r++){
            if(nums[r]==0){
                zero_count++;
            }
            while(zero_count>k){
                if(nums[l]==0){
                    zero_count--;
                }
                l++;//using shrinking window approach
            
            }
           
            ans=Math.max(ans,r-l+1);

        }
        return ans;

    }
}

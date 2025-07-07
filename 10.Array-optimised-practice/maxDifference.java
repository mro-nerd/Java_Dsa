//# Give max difference of nums[j]-nums[i] such that 0<i<j .if such i and j exists.


public class maxDifference {
    public static void main(String[] args) {
     int nums[]={1,5,3,6,7,2,0};
     System.out.println(maximumDifference(nums));   
    }
    public static int maximumDifference(int[] nums) {
        int ans=-1;
        int min_till_now = Integer.MAX_VALUE;
        for(int j =0; j<nums.length;j++){
            if(nums[j]>min_till_now){
                ans = Math.max(ans, nums[j]-min_till_now);
            }
            min_till_now = Math.min(min_till_now,nums[j] );
        }
        return ans;
    }
}

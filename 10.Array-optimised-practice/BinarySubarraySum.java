// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

public class BinarySubarraySum {
    public static void main(String[] args){
        int nums[]={1,0,0,1,1,1};
        int goal=3;
        int res=atMost(nums, goal) - atMost(nums, goal-1);
        System.out.println(res);
    }
    public static int atMost(int[] nums, int k){
        if(k<0){
          return 0;
      }
      int n=nums.length;
      int sum=0,ans=0,i=0,j=0;
      while(j<n){
          sum+=nums[j];
          while(sum>k && i<=j){
             sum-=nums[i];
             i++;
          }
          ans+=j-i+1;
          j++;

      }
      return ans;
  }
}

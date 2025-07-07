//given int array nums.s any is subarray of length m is called alternating subarray if s[1]-s[0]=1,s[2]-s[1]=-1,s[3]-s[2]=1,...s[m]-s[m-1]=(-1)^m. find the alternating subarray with maximum length.

public class alternatingSubarray {
    public static void main(String[] args) {
        int nums[]={2,3,4,3,4};
        System.out.println(alternatingSubarrays(nums));
    }
    public static int alternatingSubarrays(int[] nums) {
        int ans = 0, curr = 0, n = nums.length;
  //if curr is even then it means next difference we need is 1(as it starts with 1),if curr is odd then it means we need -1 next.      
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                if (curr % 2 == 0)
                    curr++;
                else
                    curr = 1;
            } else if (nums[i] - nums[i - 1] == -1) {
                if (curr % 2 == 1)
                    curr++;
                else
                    curr = 0;//since it doesnt starts with -1
            } else {
                curr = 0;
            }
            ans = Math.max(ans, curr + 1);//since curr was keeping track of differences(s[1]-s[0],s[2]-s[1] : here curr would be 2 but actual length is 3 .) and length is diference+1
        }
        
        if (ans == 1)
            return -1;
        return ans;
    }
}

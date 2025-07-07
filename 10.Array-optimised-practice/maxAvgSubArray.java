// #Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.

public class maxAvgSubArray {
    public static void main(String[] args){
        int a[]={1,12,-5,-6,50,3};
        int k=4;
        System.out.println(findMaxAverage(a, k));
    }
    public static double findMaxAverage(int[] nums, int k) {
        double res =Double.NEGATIVE_INFINITY;
        int start=0;
        int end=0;
        double sum=0;
        while(end<=nums.length-1){
            sum+=nums[end];
            if(end-start+1==k){
                res=Math.max(res,(sum/k));
                sum-=nums[start++];
            }
            end++;
        }
        return res;
    }
}

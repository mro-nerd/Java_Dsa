public class kadaneAlgo {
    public static void kadane(int numbers[]) {
        int currSum=0;
        int maxSum =Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            currSum=currSum+numbers[i];
            
            if(currSum<0){
                currSum=0;
            }
          //  System.out.println(currSum);
            maxSum=Math.max(maxSum,currSum);
        }
        System.out.println("Max-sum in  sub array: " + maxSum);

    }

    public static void main(String[] args) {
        int numbers[] = {-1,2,-3,4,-5,6,7};
        kadane(numbers);

    }
}
  //this is code for max sum of sub array for the case when all the numbers in our array  are negative 
// public class sol {
    
//         public static int maxSubArray(int[] nums) {
//             int currSum=0;
//             int tp=0;
//             int sum = Integer.MIN_VALUE;
//             for (int i = 0; i < nums.length; i++) {
//                  if(nums[i]<0){
//                     tp++;
                   
//                 }
//             }
//             for(int i=0;i<nums.length;i++){
               
//                  if(tp == nums.length){
//                        sum=Math.max(sum,nums[i]);
                    
//                  }else{
//                 currSum=currSum+nums[i];
//                 if(currSum<0){
//                     currSum=0;
//                 }
//                 sum=Math.max(sum,currSum);}
//             }
//             return sum;
//         }
    
//     public static void main(String[] args) {
//         int nums[]={-1,-2,-6};
//         System.out.println(maxSubArray(nums));
//     }
// }



 
//to get the max_sum among the sums of all the sub arrays

 /*
   * Also there is this better solution:-
   * class Solution {
    public int maxSubArray(int[] nums) {
        int currSum=0;
     
        int sum = Integer.MIN_VALUE;
         
        for(int i=0;i<nums.length;i++){
          
           
            currSum=Math.max(nums[i],currSum+nums[i]);
        
            sum=Math.max(sum,currSum);
        }
        return sum;
    }
}
   * 
   * 
   * 
   */
/*# an array consist of n distict numbers from 0 to n but one number is missing from array out of these n+1 numbers find that missing no. *
 * ex- [0,1,3,4,5,] ; here mising no. is 2
 */
public class missing_num{
    public static void main(String[] args) {
        int arr[]={2,4,1,6,3,7,8,0};
        System.out.println(missing_number(arr));
    }

    //brute force

    //  public static int missing_number(int a[]){
    //      int missingNumber=-1;
    //      int n = a.length;
    //      for(int i=0; i<n; i++){
    //     boolean isFound= false;
    //     for(int nums:a){ //it means nums will iterate over a[]
    //         if (nums == i) {
    //             isFound=true;
    //             break;
    //         }
    //     }
    //     if(!isFound){
    //         missingNumber = i;
    //         break;
    //     }
    //      }
     
         
    //      return missingNumber;
    // }
//optimized solution 
    public static int missing_number(int[] nums) {
        int n = nums.length;
        int ans = (n*(n+1))/2;
        for (int i=0; i<n;i++){
            ans-=nums[i];
        }
        return ans;
    }
}

//also we can use bit manipulation via xor ,as xor gives 0 when same numbers are there now when we XOR range 0 to n with whole array then we will get the missing number. 

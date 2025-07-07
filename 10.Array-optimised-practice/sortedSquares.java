// # Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

public class sortedSquares {
    public static void main(String[] args) {
        int a[]={-4,-1,0,3,10};
        int res[]=sortedSquare(a);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
        
    }
    public static int[] sortedSquare(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int i=0;
        int j=n-1;
        int ansptr=n-1;
        while(i<=j){
           int x=nums[i]*nums[i];
           int y=nums[j]*nums[j];
           if(x>y){
            ans[ansptr--]=x;
            i++;
           }
           else{
            ans[ansptr--]=y;
            j--;
           }
        }
        return ans;
    }
}

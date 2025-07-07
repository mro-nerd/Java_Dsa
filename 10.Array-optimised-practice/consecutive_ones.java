/*# Given an array a[] , return teh max no. of consecutive ones in array */
public class consecutive_ones {
    public static void main(String[] args) {
        int a[]={1,0,0,1,1,1,0,1,0,1,0};
        System.out.println(ones(a));
    }
    public static int ones(int a[]){
        int curr_ones=0;
        int final_ans=0;
        for(int num:a){
            if (num==0) {
                curr_ones=0;//sliding window approach for optimising the code
            }
            else{
                curr_ones++;
                final_ans=Math.max(final_ans,curr_ones);
            }
        }
        return final_ans;
    }
}

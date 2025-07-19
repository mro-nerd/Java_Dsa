/*give set of all the subsets of given array */
import java.util.ArrayList;
import java.util.List;

public class powerSet {
    public static void main(String[] args){
        int nums[]={1,2,3,};
        System.out.println(subsets(nums));
    }
    public static void recursion(int index, int n, List<Integer>temp, List<List<Integer>>ans, int[] nums1){
        if(index==n){//base case
            ans.add(new ArrayList<>(temp));
            return;
        }
        //case1: exclude the no. and move on 
        recursion(index+1,n,temp,ans,nums1);

        //case2: include the number and move on
        temp.add(nums1[index]);
        recursion(index+1,n,temp,ans,nums1);

        //case3: remove the no. go to prev cases to explore other options.
        temp.remove(temp.size()-1);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer>temp = new ArrayList<Integer>();
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        int n=nums.length;
        recursion(0,n,temp,ans,nums);
        return ans;
    }
}

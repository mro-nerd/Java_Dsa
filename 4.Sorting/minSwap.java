/*Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order. */

import java.util.Arrays;
import java.util.Comparator;

public class minSwap {
    public static void main(String[] args) {
        int nums[]={5,2,1,9,4,7};
        System.out.println(minSwaps(nums));
    }
      public static int minSwaps(int nums[])
    {
        
        Pair[] arr = new Pair[nums.length];
        
        
        for(int i=0;i<nums.length;i++) {
            arr[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(arr, new Custom_Comparator());
        
        int swaps = 0;
        
        int i=0;
        while(i < arr.length) {
            Pair p = arr[i];
            
            if(p.index == i) {
                i++;
            } else {
                Pair temp = arr[p.index];
                arr[p.index] = arr[i];
                arr[i] = temp;       
                swaps++;

            }
        }
        
        return swaps;

    }
    
    public static class Pair {
        int value;
        int index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
   public static class Custom_Comparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return p1.value - p2.value;
        }
    }
}

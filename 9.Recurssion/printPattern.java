/*Print a sequence of numbers starting with N, without using loop, where replace N with N - 5, until N < 0. After that replace N with N + 5 until N regains its initial value. */

import java.util.ArrayList;
import java.util.List;

public class printPattern {
    public static void main(String[] args) {
        int N=16;
        System.out.println(pattern(N));
    }
     public static List<Integer> pattern(int N){
        
        ArrayList<Integer> arr=new ArrayList<>();
        
        rec(N,arr);
        
        return arr;
          
    }
     public  static void rec(int N,ArrayList<Integer> arr){
		// base case
         if(N<=0){
             arr.add(N);
             return ;
         }
         arr.add(N);
         rec(N-5,arr);
         arr.add(N);
     }
}

/*Given a positive integer N, return the Nth row of pascal's triangle.
Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.
The elements can be large so return it modulo 10^9 + 7. */

import java.util.ArrayList;

public class pascalTriangle {

    public static int mod=1000000007;
    public static void main(String[] args) {
        int N=5;
        System.out.println(nthRowOfPascalTriangle(N));
    }
   public static ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> result=rec(n);
        return result;
    }
    public static ArrayList<Long> rec(int n){
        if(n==1){
            ArrayList <Long>base=new ArrayList<>();
            base.add(1L);
            return base;
        }
        ArrayList<Long> pre=rec(n-1);
        ArrayList<Long> curr=new ArrayList<>();
        curr.add(1L);
        for(int i=1;i<n-1;i++){
            curr.add((pre.get(i-1)+pre.get(i))%mod);
        }
        curr.add(1L);
        return curr;
    }
}

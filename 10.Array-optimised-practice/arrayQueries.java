// # given an array of all zeros and queries are given, each query has l,r,1 -meanig 1 is to be added from a[l] to a[r] print final stage of array after all queries are processed.

//ex:- a={0,0,0,0,0,0,0} Q1- 1 to 3 , Q2- 2 to 5 
//  a={0,1,1,1,0,0,0} => {0,1,2,2,1,1,0}

import java.util.Scanner;

public class arrayQueries {
    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int Q = sc.nextInt();

         int a[] = new int[N];
        for(int i = 0; i < Q; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            a[l] +=1;
            if (r+1<N) {
                a[r+1] -= 1;
            }
        }
        for(int i = 1; i < N; i++){//prefix sum array
            a[i] += a[i-1];
        }
        for (int nums :a){ //printing output
            System.out.println(nums);
        }
       sc.close();
    }
}

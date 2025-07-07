// #Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.

import java.util.ArrayList;

public class commonElement {
    public static void main(String[] args){
        int a[]={11,13,20,40,45,90};
        int b[]={33,39,40,42,45,60,70,90};
        int c[]={1,3,5,7,8,40,45,69,90};
        int n1=6;
        int n2=8;
        int n3=9;
        System.out.println(commonElements(a, b, c, n1, n2, n3));
    }
     public static ArrayList<Integer>  commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // Initialize three pointers for each array
        int i = 0, j = 0, k = 0;
        
        // Initialize an arraylist to store the common elements
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        // Initialize a variable to store the last checked element
        int last = Integer.MIN_VALUE;

        // Loop until any of the three arrays reaches its end
        while (i < n1 && j < n2 && k < n3)
        {
            // If the current elements of all three arrays are equal and not the same as the last checked element
            if (A[i] == B[j] && A[i] == C[k] && A[i] != last) 
            {
                // Add the common element to the result arraylist
                res.add (A[i]);
                
                // Update the last checked element
                last = A[i];
                
                // Move to the next element in each array
                i++;
                j++;
                k++;
            }
            // If the current element of array A is the smallest, move to the next element in array A
            else if (Math.min (A[i], Math.min(B[j], C[k])) == A[i]) i++;
            // If the current element of array B is the smallest, move to the next element in array B
            else if (Math.min (A[i], Math.min(B[j], C[k])) == B[j]) j++;
            // If the current element of array C is the smallest, move to the next element in array C
            else k++;
        }
        
        // Return the arraylist of common elements
        return res;
    }
}

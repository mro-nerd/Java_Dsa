/*
Problem:
---------
We are given an array of size n. 
We need to count the number of pairs of **non-overlapping subarrays**.

Example:
---------
If n = 3 and array = [1, 2, 3]
Possible valid pairs:
    {[1][2]}, {[2][3]}, {[1][3]}, {[1][2,3]}, {[1,2][3]}
So total = 5.

Intuition:
----------
Any valid pair of non-overlapping subarrays can be formed in these cases:

1. **Two single elements (size 1 + size 1)**  
   - Choose any 2 indices → nC2 ways.

2. **One single element + one subarray of length ≥ 2 (size 1 + size ≥2)**  
   - Choose 3 indices, the middle one will "separate" the two subarrays.  
   - Each choice of 3 indices can form 2 valid pairs (left+right OR right+left).  
   - Count = 2 * nC3.

3. **Two subarrays of size ≥ 2 each**  
   - Choose 4 indices, first two form the left subarray and last two form the right subarray.  
   - Count = nC4.

So, total = nC2 + 2*nC3 + nC4.
*/

import java.util.*;

public class nonOverlappingSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt(); // Size of array

        // Compute binomial coefficients directly (no need for factorial precomputation)
        long nC2 = n * (n - 1) / 2;                // Number of ways to choose 2 indices
        long nC3 = n * (n - 1) * (n - 2) / 6;      // Number of ways to choose 3 indices
        long nC4 = n * (n - 1) * (n - 2) * (n - 3) / 24; // Number of ways to choose 4 indices

        // Final answer = contributions from the 3 cases
        long ans = nC2 + 2 * nC3 + nC4;

        System.out.println(ans);
    }
}

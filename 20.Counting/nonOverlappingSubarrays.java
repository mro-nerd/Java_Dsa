/*Find number of pairs of non overlapping subarrays if n is the size of array. 1 <= n <= 10^4.
 Ex:
 Innput:3
 Output:5
 Explaination: if [1,2,3] is our array then valid pairs would be,
 {[1][2]},{[2][3]},{[1][3]},{[1][2,3]},{[1,2][3]}
 */

import java.util.*;

public class nonOverlappingSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        long nC2 = n*(n-1)/2;
        long nC3 = n*(n-1)*(n-2)/6;
        long nC4 = n*(n-1)*(n-2)*(n-3)/24;

        long ans = nC2 + 2*nC3 + nC4;
        System.out.println(ans);
    }
}
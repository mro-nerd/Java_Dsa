/*Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.
The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.

Example 1:

Input: arr = [0]
Output: 1
Explanation: There is only one possible result: 0.
Example 2:

Input: arr = [1,1,2]
Output: 3
Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values, so the answer is 3. */

import java.util.*;

public class subarrayOR {
    public static int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        Set<Integer> cur2;
        
        for (int i : arr) {
            cur2 = new HashSet<>();
            cur2.add(i);
            for (int j : cur)
                cur2.add(i | j);
            cur = cur2;
            res.addAll(cur);
        }
        
        return res.size();
    }
    public static void main(String[] args) {
        int num[]={1,1,2};
        int ans=subarrayBitwiseORs(num);
        System.out.println(ans);
    }
}

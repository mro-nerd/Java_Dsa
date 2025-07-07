/*Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing the value of coins required. 


Example 1:

Input: N = 43
Output: 20 20 2 1
Explaination: 
Minimum number of coins and notes needed 
to make 43. */

import java.util.*;

public class minCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution obj = new Solution();
        List<Integer> ans = obj.minPartition(n);
        for (int x : ans)
            System.out.print(x + " ");
        scanner.close();
    }
}

class Solution {
    public  List<Integer> minPartition(int N) {
        List<Integer> ans = new ArrayList<>();
        int[] value = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        for (int i = 0; i < 10; i++) {
            int curr = N / value[i];
            //System.out.println("curr:"+curr);
            N %= value[i];
            for (int j = 0; j < curr; j++){
                ans.add(value[i]);
                //System.out.println("ans:"+value[i]);
            }    
        }
        return ans;
    }
}

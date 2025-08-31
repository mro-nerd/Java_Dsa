/* You are given a binary string s, and a 2D integer array queries where queries[i] = [firsti, secondi].
For the ith query, find the shortest substring of s whose decimal value, val, yields secondi when bitwise XORed with firsti. In other words, val ^ firsti == secondi.
The answer to the ith query is the endpoints (0-indexed) of the substring [lefti, righti] or [-1, -1] if no such substring exists. If there are multiple answers, choose the one with the minimum lefti.

Return an array ans where ans[i] = [lefti, righti] is the answer to the ith query.

Example 1:

Input: s = "101101", queries = [[0,5],[1,2]]
Output: [[0,2],[2,3]]
Explanation: For the first query the substring in range [0,2] is "101" which has a decimal value of 5, and 5 ^ 0 = 5, hence the answer to the first query is [0,2]. In the second query, the substring in range [2,3] is "11", and has a decimal value of 3, and 3 ^ 1 = 2. So, [2,3] is returned for the second query. 
*/

import java.util.*;

public class xorQueries {
    public static int[][] substringXorQueries(String s, int[][] queries) {
        List<int[]> ans = new ArrayList<>();
        int n = s.length();

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (!map.containsKey(0)) {
                    map.put(0, new int[]{i, i});
                }
                continue;
            }
            int curr = 0;
            for (int j = i; j < Math.min(n, i + 32); j++) {
                curr = (curr << 1) + (s.charAt(j) - '0');
                if (!map.containsKey(curr)) {
                    map.put(curr, new int[]{i, j});
                }
            }
        }

        for (int[] query : queries) {
            int t = query[0] ^ query[1];
            if (!map.containsKey(t)) {
                ans.add(new int[]{-1, -1});
            } else {
                ans.add(map.get(t));
            }
        }
        
        return ans.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        String s="101101";
        int query[][]={{0,5},{1,2}};
        int ans[][]=substringXorQueries(s, query);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
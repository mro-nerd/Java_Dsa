/*You are given a 2D integer array items where items[i] = [pricei, beautyi] denotes the price and beauty of an item respectively.
You are also given a 0-indexed integer array queries. For each queries[j], you want to determine the maximum beauty of an item whose price is less than or equal to queries[j]. If no such item exists, then the answer to this query is 0.
Return an array answer of the same length as queries where answer[j] is the answer to the jth query.

Example: Input: items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
         Output: [2,4,5,5,6,6]

Explanation:
- For queries[0]=1, [1,2] is the only item which has price <= 1. Hence, the answer for this query is 2.
- For queries[1]=2, the items which can be considered are [1,2] and [2,4]. 
  The maximum beauty among them is 4.
- For queries[2]=3 and queries[3]=4, the items which can be considered are [1,2], [3,2], [2,4], and [3,5].
  The maximum beauty among them is 5.
- For queries[4]=5 and queries[5]=6, all items can be considered.
  Hence, the answer for them is the maximum beauty of all items, i.e., 6.

  */

import java.util.Arrays;
import java.util.Comparator;

public class beautifulItems {
    public static void main(String[] args) {
        int items[][]={{1,2},{3,2},{2,4},{5,6},{3,5}};
        int query[]={1,2,3,4,5,6};
        int res[]=maximumBeauty(items, query);
        for(int nums:res){
            System.out.println(nums);

        }
    }
     public static  int[] maximumBeauty(int[][] items, int[] queries) {
       int n = queries.length, m = items.length;
        Arrays.sort(items, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[n];

        for (int i = 0; i < m; i++)
            items[i][1] = Math.max(items[i][1], items[i > 0? i - 1 : 0][1]);//creating max array
        
        for (int i=0;i<n;i++){

            int lo = 0, hi = m - 1,q=queries[i];
             while (lo <= hi) {                  //searching via BS
                int mid = lo + (hi - lo) / 2;
                if (items[mid][0] <= q) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
             }    
             ans[i] = (hi >= 0) ? items[hi][1] : 0;
        }

        return ans;

    }
}

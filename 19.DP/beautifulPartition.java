/*  
Sidaga considers a sequence beautiful if the sum of its elements is strictly positive.  
We need to partition the sequence into exactly K non-empty contiguous subsequences, such that:  
1. Each subsequence has strictly positive sum.  
2. Every element belongs to exactly one subsequence.  

We print "YES" and one valid partition if possible, else "NO".  
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class beautifulPartition {
    
    // Utility function: Binary search to find "lower bound" in dp[]
    // i.e., the smallest index where dp[mid] >= val
    static int lowerBound(long dp[], long val) {
        int beg = 0, end = dp.length - 1, ans = dp.length;
        while(beg <= end) {
            int mid = (beg + end) / 2;
            if(dp[mid] >= val) {
                ans = mid;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return ans;
    }

    // Function to find the longest increasing subsequence (LIS) of prefix sums
    // val[] contains prefix sums that are valid "cut points"
    // index[] contains the indices of those prefix sums in the array
    static int[] getCuts(ArrayList<Long> val, ArrayList<Integer> index) {
        if(val.isEmpty()) {
            return new int[]{};
        }

        // dp[i] will store the smallest possible ending value of an increasing subsequence of length i
        long dp[] = new long[val.size() + 1];
        // idVal[i] stores the index in val[] that ends the LIS of length i
        int idVal[] = new int[val.size() + 1];
        // par[i] helps reconstruct the LIS (stores parent indices)
        int par[] = new int[val.size() + 1];

        Arrays.fill(dp, Long.MAX_VALUE);
        Arrays.fill(idVal, -1);
        Arrays.fill(par, -1);
        dp[0] = Long.MIN_VALUE; // LIS of length 0 is "empty"

        // Build LIS using patience sorting idea
        for(int i = 0; i < val.size(); ++i) {
            int id = lowerBound(dp, val.get(i));
            if(id < dp.length) {
                dp[id] = val.get(i);
                idVal[id] = i;
                par[idVal[id]] = idVal[id - 1]; // link current index to previous LIS element
            }
        }

        // Find the length of LIS
        int len = 0;
        for(int i = 1; i < dp.length; i++) {
            if(dp[i] < Long.MAX_VALUE) {
                len = i;
            }
        }

        // Reconstruct LIS cuts using parent pointers
        int[] ans = new int[len];
        int id = idVal[len];
        for(int i = len - 1; i >= 0; --i) {
            ans[i] = index.get(id);  // store cut position
            id = par[id];
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());  // number of test cases
        
        while(t-- > 0) {
            String line[] = r.readLine().split(" ");
            int n = Integer.parseInt(line[0]); // size of sequence
            int k = Integer.parseInt(line[1]); // number of required subsequences
            
            int a[] = new int[n];    // original array
            long pre[] = new long[n]; // prefix sums
            String line2[] = r.readLine().split(" ");

            // Build array and prefix sums
            for(int i = 0; i < n; ++i) {
                a[i] = Integer.parseInt(line2[i]);
                pre[i] = i == 0 ? a[i] : pre[i - 1] + a[i];
            }

            // Special case: only 1 subsequence needed
            if(k == 1) {
                if(pre[n - 1] > 0) {
                    w.print("YES\n");
                    w.print(n); // whole array as one subsequence
                } else {
                    w.print("NO");
                }
                w.print("\n");
                continue;
            }

            // Collect valid cut points:
            // prefix sums that are strictly positive and less than total sum
            ArrayList<Long> val = new ArrayList<>();
            ArrayList<Integer> index = new ArrayList<>();
            
            for(int i = 0; i < n - 1; ++i) {
                if(pre[i] > 0 && pre[i] < pre[n - 1]) {
                    val.add(pre[i]);
                    index.add(i);
                }
            }

            // Get the longest chain of increasing prefix sums (valid cuts)
            int[] cuts = getCuts(val, index);
            
            if(cuts.length < k - 1) {
                // Not enough cuts to make K parts
                w.print("NO\n");
            } else {
                w.print("YES\n");
                
                // Print lengths of subsequences
                // First subsequence length
                w.print(cuts[0] + 1);
                w.print(" ");
                
                // Middle subsequences
                for(int i = 1; i < k - 1; ++i) {
                    w.print(cuts[i] - cuts[i - 1]);
                    w.print(" ");
                }
                
                // Last subsequence length
                w.print(n - 1 - cuts[k - 2]);
                w.print("\n");
            }
        }

        r.close();
        w.close();
    }
}

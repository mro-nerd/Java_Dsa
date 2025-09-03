/*
Problem:
---------
We want to distribute `n` candies among 3 children (x, y, z),
such that:
   0 <= x, y, z <= limit

We need to count the number of valid distributions.

Key Idea:
---------
1. Without the "limit" restriction:
   - Count number of non-negative integer solutions to:
        x + y + z = n
   - Using "stars and bars": C(n+2, 2) 
   star and bars is used when we want to distribute n things among k distinct groups by chosing the position of k-1 dividers{
   Stars and Bars Idea:
   Think of the n candies as stars (*).To divide them among k children, we place bars (|) as dividers.
   👉 Example: n=5,k=3 (5 candies, 3 children).We need k−1=2 bars to split into 3 groups.

        **|***|    → Child1 gets 2, Child2 gets 3, Child3 gets 0
        *|**|**    → Child1 gets 1, Child2 gets 2, Child3 gets 2


    So every arrangement of stars and bars corresponds to one distribution.
   }

2. With "limit":
   - We apply **Inclusion-Exclusion**:
    
   - Subtract distributions where one child exceeds limit , i.e he had atleast limit+1 candies. So we will fist remove those limit+1 candies from n+k-1, then we will substract the no.of ways it will give 3 times(As any one of 3 element can exceed limit) for selecting 2 dividers out of (n-k+1-limit+1) candies, if you notice we are still taking two dividers i.e we are still giving more candies to that one child who has already limit+1 candies is because he had 'atleast' limit+1 candies so he can have more as well if it is possible same logic will be followed for other cases as well.
    
   - Add back distributions where two children exceed limit
       (because they got subtracted twice: 
       We subtracted all cases where one child > limit.
       But imagine a distribution where two children are both above the limit.

       Example:n=8,limit=3.
        Distribution = (4,4,0).
        This belongs to A1 (child1 ≥ 4).
        Also belongs to A2 (child2 ≥ 4).
        When we did - (|A1| + |A2| + |A3|),
        this case was subtracted twice.).

   - Subtract distributions where all three exceed limit.

   Formula:
   ----------
   Answer =
       ways(n)                                      // total without restriction
       - 3 * ways(n - (limit+1))                    // at least one child > limit
       + 3 * ways(n - 2*(limit+1))                  // at least two children > limit
       - 1 * ways(n - 3*(limit+1))                  // all three > limit

   Here:
       ways(k) = number of solutions of x+y+z = k (if k >= 0)
                = C(k+2, 2)

Example 1:
-----------
n=5, limit=2
Total ways without restriction = C(7,2)=21
Subtract when one child >2 → 3* C(4,2)=18
Add when two children >2 → 3* C(1,2)=0
Subtract when three children >2 → C(-2,2)=0
Answer = 21-18 = 3 ✅

*/

public class distributeCandies {
    public static void main(String[] args) {
        int n = 3, limit = 3;

        // limit+1 is the threshold beyond which a child exceeds limit
        int limitPlusOne = limit + 1;

        // Case when 1 child exceeds limit
        int oneChildExceedsLimit = ways(n - limitPlusOne);

        // Case when 2 children exceed limit
        int twoChildrenExceedLimit = ways(n - 2 * limitPlusOne);

        // Case when 3 children exceed limit
        int threeChildrenExceedLimit = ways(n - 3 * limitPlusOne);

        // Apply Inclusion-Exclusion formula
        int ans = ways(n)
                - 3 * oneChildExceedsLimit
                + 3 * twoChildrenExceedLimit
                - threeChildrenExceedLimit;

        System.out.println(ans);  // final answer
    }

    // Counts number of non-negative integer solutions to x+y+z=n
    private static int ways(int n) {
        if (n < 0) return 0;  // impossible
        return nCk(n + 2, 2); // stars and bars formula: C(n+3-1,3-1) = C(n+2,2)
    }

    // Computes nCk (binomial coefficient) iteratively
    private static int nCk(int n, int k) {
        int res = 1;
        for (int i = 1; i <= k; ++i) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }
}

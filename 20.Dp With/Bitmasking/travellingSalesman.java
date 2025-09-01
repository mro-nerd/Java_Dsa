/*Given a matrix cost of size n where cost[i][j] denotes the cost of moving from city i to city j. Your task is to complete a tour from city 0 (0-based index) to all other cities such that you visit each city exactly once and then at the end come back to city 0 at minimum cost.

Examples:

Input: cost = [[0, 111], [112, 0]]
Output: 223
Explanation: We can visit 0->1->0 and cost = 111 + 112.
Input: cost = [[0, 1000, 5000], [5000, 0, 1000], [1000, 5000, 0]]
Output: 3000
Explanation: We can visit 0->1->2->0 and cost = 1000+1000+1000 = 3000
Constraints:
1 <= cost.size() <= 20
1 <= cost[i][j] <= 103 */

public class travellingSalesman {
    // This variable will store the bitmask when ALL cities have been visited.
    static int visited_all;

    public static void main(String[] args) {
        int cost[][]={{0, 1000, 5000}, {5000, 0, 1000}, {1000, 5000, 0}};
        int n = cost.length;

        // Example: if n=4, (1<<4)-1 = 1111 (in binary) → all 4 cities visited
        visited_all = (1 << n) - 1;

        // Total possible states = 2^n (all subsets of cities visited)
        int rows = (int) Math.pow(2, n);

        // dp[mask][pos] → stores the minimum cost when:
        // "mask" = set of visited cities, "pos" = current city
        Integer[][] dp = new Integer[rows][n];

        // Start from city 0, with only city 0 visited (mask = 1)
        int ans= tsp(1, 0, dp, cost);
        System.out.println(ans);
    }

    // Recursive function to solve TSP
    static int tsp(int mask, int pos, Integer[][] dp, int[][] cost) {
        // Base Case: If all cities are visited,
        // return cost to go back to city 0 (complete the cycle)
        if (mask == visited_all) {
            return cost[pos][0];
        }

        // If we have already solved this state, return stored value
        if (dp[mask][pos] != null) {
            return dp[mask][pos];
        }

        int ans = Integer.MAX_VALUE; // Start with a large number (infinity)

        // Try visiting all other cities
        for (int city = 0; city < cost.length; city++) {
            // Check if this city is NOT visited yet
            if ((mask & (1 << city)) == 0) {
                // Visit this city:
                // 1. Add travel cost from "pos" → "city"
                // 2. Mark "city" as visited in mask (mask | (1<<city))
                // 3. Continue recursion from that city
                int newAns = cost[pos][city] + tsp(mask | (1 << city), city, dp, cost);

                // Take the minimum across all choices
                ans = Math.min(ans, newAns);
            }
        }

        // Save result in dp table before returning
        return dp[mask][pos] = ans;
    }
}

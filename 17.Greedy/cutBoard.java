/*A board of length m and width n is given. The task is to break this board into m*n squares such that cost of breaking is minimum. The cutting cost for each edge will be given for the board in two arrays x[] and y[]. In short, you need to choose such a sequence of cutting such that cost is minimized. Return the minimized cost.

Examples

Input:m = 6, n= 4, x[] = {2, 1, 3, 1, 4}, y[] = {4, 1, 2}

Output: 42

Explanation: 

For above board optimal way to cut into square is:
Total minimum cost in above case is 42. It is 
evaluated using following steps.
Initial Value : Total_cost = 0
Total_cost = Total_cost + edge_cost * total_pieces
Cost 4 Horizontal cut:      Cost = 0 + 4*1 = 4
Cost 4 Vertical cut:        Cost = 4 + 4*2 = 12
Cost 3 Vertical cut:        Cost = 12 + 3*2 = 18
Cost 2 Horizontal cut:      Cost = 18 + 2*3 = 24
Cost 2 Vertical cut:        Cost = 24 + 2*3 = 30
Cost 1 Horizontal cut:      Cost = 30 + 1*4 = 34
Cost 1 Vertical cut:        Cost = 34 + 1*4 = 38
Cost 1 Vertical cut:        Cost = 38 + 1*4 = 42 */

import java.util.*;

public class cutBoard {

    public static int minimumCostOfBreaking(int[] X, int[] Y, int M, int N) {
        int cost = 0;
        int h = 1, v = 1;
        Arrays.sort(X); // sort the horizontal array
        Arrays.sort(Y); // sort the vertical array
        int i = X.length - 1; // Index for horizontal cuts
        int j = Y.length - 1; // Index for vertical cuts

        while (i >= 0 && j >= 0) {
            if (X[i] >= Y[j]) {
                cost += X[i] * v;
                h++;
                i--;
            } else {
                cost += Y[j] * h;
                v++;
                j--;
            }
        }
        while (i >= 0) {
            cost += X[i] * v;
            i--;
        }
        while (j >= 0) {
            cost += Y[j] * h;
            j--;
        }
        return cost;
    }

    // Main function to test the method
    public static void main(String[] args) {
        int[] X = {2, 1, 3, 1, 4}; // Horizontal costs
        int[] Y = {4, 1, 2}; // Vertical costs
        int M = X.length;
        int N = Y.length;

        int result = minimumCostOfBreaking(X, Y, M, N);
        System.out.println("Minimum Cost of Breaking: " + result);
    }
}
   


/*You are given n disks placed on a starting rod (from), with the smallest disk on top and the largest at the bottom. There are three rods: the starting rod(from), the target rod (to), and an auxiliary rod (aux).
You have to calculate the total number of moves required to transfer all n disks from the starting rod to the target rod, following these rules:
      1. Only one disk can be moved at a time.
      2. A disk can only be placed on top of a larger disk or on an empty rod.
Return the number of moves needed to complete the task.

Examples:

Input: n = 2
Output: 3
Explanation: For n =2 , steps will be as follows in the example and total 3 steps will be taken.
move disk 1 from rod 1 to rod 2
move disk 2 from rod 1 to rod 3
move disk 1 from rod 2 to rod 3
Input: n = 3
Output: 7
Explanation: For N=3 , steps will be as follows in the example and total 7 steps will be taken.
move disk 1 from rod 1 to rod 3
move disk 2 from rod 1 to rod 2
move disk 1 from rod 3 to rod 2
move disk 3 from rod 1 to rod 3
move disk 1 from rod 2 to rod 1
move disk 2 from rod 2 to rod 3
move disk 1 from rod 1 to rod 3 */

import java.util.*;
public class towerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}


class Hanoi {
    public long toh(int N, int from, int to, int aux) {
        if(N == 0) // base case
            return 0;
        
        long moves = 0;
        
        // Transfer N - 1 discs from 'from' to 'aux' by taking
        // the help of 'to'
        moves += toh(N - 1, from, aux, to);
        
        // Now, move the last Nth disc from 'from' to 'to'.
        moves += 1;
        System.out.println("move disk " + N + " from rod " + from +
                               " to rod " + to);
        
        // Now, put back all those N - 1 discs from 'aux' to 'to' by taking
        // the help of 'from'.
        moves += toh(N - 1, aux, to, from);
        return moves;
    }
}
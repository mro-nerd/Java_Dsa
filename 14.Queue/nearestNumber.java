/*Give the nearest no. to the given input no. which only consist of digits 2,3 and 5
 * 
 eg: Input : 7 
    Output : 32
 
 Input                Output
 -----                ------
  1                    2
  2                    3 
  3                    5
  4                    22
  5                    23
  6                    25 
  7                    32
      
 */

import java.util.*;
public class nearestNumber {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(2); q.add(3); q.add(5);
        for(int i = 0; i < n - 1; ++i) {
            int num = q.poll();
            q.add(10*num + 2);
            q.add(10*num + 3);
            q.add(10*num + 5);
        }

        System.out.println(q.peek());
        sc.close();
    }
}

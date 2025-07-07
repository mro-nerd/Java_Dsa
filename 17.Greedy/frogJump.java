/*N lilypads are there, N-1 are in pond and Nth one is on other side of pond .d[i] is distances btw ith and i+1th lilypad. The frog csn Jump upto k units in one hoop. Tell if it is possible for frog to reach other end? If yes then what are min jumps required.

Example:
Input:N=5, d[]=[5, 3, 1, 2, 8], k=9
Output:3
*/

import java.util.*;

public class frogJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int d[] = new int[n];
        for(int i = 0; i < n; ++i)
            d[i] = sc.nextInt();
        sc.close();
        int curId = 0, minJumps = 0;
        while(curId < n) {
            int nextId = curId, curDist = 0;
            while(nextId + 1 <= n && curDist + d[nextId] <= k) {
                curDist += d[nextId];
                nextId += 1;
            }

            if(curId == nextId) {
                System.out.println(-1);
                return;
            }


            curId = nextId;
            minJumps += 1;
        }
        System.out.println(minJumps);
    }
}
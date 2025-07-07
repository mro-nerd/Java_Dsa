/*You need to design a class RecentCounter that keeps track of requests made in the past 3000 milliseconds (ms).

# The class has a method ping(int t), where t is the time (in ms) when a request is made.
# It should return the number of requests made in the last 3000 ms, including the current request.
# request is counted if it happened within the range [t - 3000, t].
# The given times always increase with each ping(t). 

eg:
Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]

Output
[null, 1, 2, 3, 3]

Explanation
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1], range = [-2999, 1] → return 1
recentCounter.ping(100);   // requests = [1, 100], range = [-2900, 100] → return 2
recentCounter.ping(3001);  // requests = [1, 100, 3001], range = [1, 3001] → return 3
recentCounter.ping(3002);  // requests = [100, 3001, 3002], range = [2, 3002] → return 3
*/

import java.util.Queue;
import java.util.LinkedList;

class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.offer(t);

        while (!q.isEmpty() && q.peek() < t - 3000) {
            q.poll();
        }

        return q.size();
    }
}

public class recentTickets {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

        // Test cases
        System.out.println(recentCounter.ping(1));    // Expected Output: 1
        System.out.println(recentCounter.ping(100));  // Expected Output: 2
        System.out.println(recentCounter.ping(3001)); // Expected Output: 3
        System.out.println(recentCounter.ping(3002)); // Expected Output: 3
    }
}


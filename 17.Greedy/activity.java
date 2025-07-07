/*You are given a set of activities, each with a start time and a finish time, represented by the arrays start[] and finish[], respectively. A single person can perform only one activity at a time, meaning no two activities can overlap. Your task is to determine the maximum number of activities that a person can complete in a day.

Example: 
Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: A person can perform at most four activities. The maximum set of activities that can be executed is {0, 1, 3, 4}
 */

import java.util.*;

class Activities {
    public int start;
    public int end;
    
    Activities(int st, int en) {
        start = st;
        end = en;
    }
}

public class activity {
    // Function to find the maximum number of activities that can
    // be performed by a single person.
    public static int activitySelection(int start[], int end[], int n) {
        ArrayList<Activities> act = new ArrayList<>();
        
        for (int i = 0; i < n; ++i)
            act.add(new Activities(start[i], end[i]));
        
        Collections.sort(act, (a1, a2) -> a1.end - a2.end);
        
        int maxActivities = 1, lastEnd = act.get(0).end;
        
        for (int i = 1; i < n; ++i) {
            int curStart = act.get(i).start;
            if (curStart > lastEnd) {
                maxActivities += 1;
                lastEnd = act.get(i).end;
            }
        }
        
        return maxActivities;
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 2, 5};
        int end[] = {2, 4, 3, 6};
        int n = start.length;
        
        int result = activitySelection(start, end, n);
        System.out.println("Maximum number of activities: " + result);
    }
}



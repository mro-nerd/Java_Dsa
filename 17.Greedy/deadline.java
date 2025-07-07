/*We'll be given N jobs with their respective timeline(duration of job) and deadline in arrays t and d.We've to do all N jobs(we can do one job at a time) Minimize the maximum lateness among all the jobs.
 
Example:
Input: N=4
       t={3,1,2,5}
       d={4,10,2,8}
Output: 2
Since the minimum lateness that we will get is 1,2 and 1 at 1st ,2nd and 3rd job and max out of them is 2.
*/

import java.util.*;

class Job {
	int time;
	int deadline;

	Job(int t, int d) {
		time = t;
		deadline = d;
	}
};

public class deadline {
	static int minMaxLateness(int time[], int deadline[], int n) {
		ArrayList<Job> job = new ArrayList<>();
		for(int i = 0; i < n; ++i) {
			job.add(new Job(time[i], deadline[i]));
		}

		Collections.sort(job, (j1,j2)->j1.deadline-j2.deadline);
		int curTime = 0, maxLatenessSoFar = 0;
		for(int i = 0; i < n; ++i) {
			int curDeadlne = job.get(i).deadline;
			int curEnd = curTime + job.get(i).time;

			maxLatenessSoFar = Math.max(maxLatenessSoFar, curEnd - curDeadlne);
			curTime = curEnd;
		}
		return maxLatenessSoFar;
	}

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int time[] = new int[n];
		int deadline[] = new int[n];

		for(int i = 0; i < n; ++i) {
			time[i] = sc.nextInt();
			deadline[i] = sc.nextInt();
		}

		System.out.println(minMaxLateness(time, deadline, n));
    }
}


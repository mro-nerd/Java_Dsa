/*You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

Your task is to find:

>>The maximum number of jobs that can be completed within their deadlines.
>>The total maximum profit earned by completing those jobs.
Examples :

Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40). */

import java.io.*;
import java.util.*;


class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

public class jobSequencing {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);
        
        TreeSet<Integer> freeSlots = new TreeSet<>();
        for(int i = 1; i <= n; ++i)
            freeSlots.add(i);
            
        int jobsDone = 0, profitEarned = 0;
        for(Job job : arr) {
            // Find the largest free slot
            // less than or equal to job.deadline;
            if(freeSlots.floor(job.deadline) == null) {
                continue;
            }
            int curSlot = freeSlots.floor(job.deadline);
            freeSlots.remove(curSlot);
            profitEarned += job.profit;
            jobsDone += 1;
        }
        return new int[]{jobsDone, profitEarned};
    }
}


/*Your friend Mishka and you attend a calculus lecture. Lecture lasts n minutes. Lecturer tells ai theorems during the i-th minute.
Mishka is really interested in calculus, though it is so hard to stay awake for all the time of lecture. You are given an array t of Mishka's behavior. If Mishka is asleep during the i-th minute of the lecture then ti will be equal to 0, otherwise it will be equal to 1. When Mishka is awake he writes down all the theorems he is being told — ai during the i-th minute. Otherwise he writes nothing.
You know some secret technique to keep Mishka awake for k minutes straight. However you can use it only once. You can start using it at the beginning of any minute between 1 and n - k + 1. If you use it on some minute i then Mishka will be awake during minutes j such that  and will write down all the theorems lecturer tells.
You task is to calculate the maximum number of theorems Mishka will be able to write down if you use your technique only once to wake him up. */

import java.util.Scanner;

public class lectureSleep {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		int[] t = new int[n];
		for(int i=0 ; i<n ; i++) {
			a[i] = sc.nextInt();
		}
		for(int i=0 ; i<n ; i++) {
			t[i] = sc.nextInt();
		}
		int[] pre = new int[n+1];
		int[] pre_weighted = new int[n+1];
		for(int i=0 ; i<n ; i++) {
			pre[i+1] = pre[i] + a[i];
			pre_weighted[i+1] = pre_weighted[i] + t[i]*a[i];
		}
		int ans = 0;
		for(int i=0 ; i<n ; i++) {
			int st = i;
			int en = i+k-1;
			if(en>=n) break;

			// if we use secret technique at index i,
			// mishka will stay awake from [st, en] no matter the value of t
			int curr = pre_weighted[st] + (pre[en+1]-pre[st]) + (pre_weighted[n] - pre_weighted[en+1]);//sumof lectures before using technique +sum of lectures attended using technique+sum of lectures after using techinque 
			ans = Math.max(ans, curr);
		}
		System.out.println(ans);
        sc.close();
    }
}

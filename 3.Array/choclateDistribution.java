/*Q) Given an array of N integers where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 

Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates given to the students is minimized. */

import java.util.Arrays;

public class choclateDistribution {
    public static int search(int a[], int m) {
        if (a.length == 0 || m == 0) {
            return 0;
        }

        if (a.length - 1 < m) {
            return -1;
        }
        int md = Integer.MAX_VALUE;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            int end = i + m - 1;
            if (end >= a.length)
                break;
            int diff = a[end] - a[i];
            md = Math.min(md, diff);

        }

        return md;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 3, 2, 4, 9, 12, 56 };
        int students = 3;
        System.out.println(search(arr, students));
    }
}

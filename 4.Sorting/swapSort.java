/*In this problem your goal is to sort an array consisting of n integers in at most n swaps. For the given array find the sequence of swaps that makes the array sorted in the non-descending order. Swaps are performed consecutively, one after another.
Note that in this problem you do not have to minimize the number of swaps — your task is to find any sequence that is no longer than n. 

The first line of the input contains integer n (1 ≤ n ≤ 3000) — the number of array elements. The second line contains elements of array: a0, a1, ..., an - 1 ( - 109 ≤ ai ≤ 109), where ai is the i-th element of the array. The elements are numerated from 0 to n - 1 from left to right. Some integers may appear in the array more than once.

In the first line print k (0 ≤ k ≤ n) — the number of swaps. Next k lines must contain the descriptions of the k swaps, one per line. Each swap should be printed as a pair of integers i, j (0 ≤ i, j ≤ n - 1), representing the swap of elements ai and aj. You can print indices in the pairs in any order. The swaps are performed in the order they appear in the output, from the first to the last. It is allowed to print i = j and swap the same pair of elements multiple times.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swapSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        List<Pair> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
	// using selection sort for sorting , as it takes n-1 swaps .a
	// swap the current minimum with the i-th element each time.
        for (int i = 0; i < n; i++) {
            int j = i;
            for (int t = i; t < n; t++) {
                if (a[j] > a[t]) {
                    j = t;
                }
            }
            if (i != j) {
                answer.add(new Pair(i, j));
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
	// This solution makes at most n-1 swap operation. 
        System.out.println(answer.size());
        for (Pair pair : answer) {
            System.out.println(pair.first + " " + pair.second);
        }
        scanner.close();
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}



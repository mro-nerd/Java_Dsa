/*You are given an integer array deck where deck[i] represents the number written on the ith card.Partition the cards into one or more groups such that:

Each group has exactly x cards where x > 1, and
All the cards in one group have the same integer written on them.
Return true if such partition is possible, or false otherwise.

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Example 2:

Input: deck = [1,2,1,2,1,3,1,3]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[1,1].*/

import java.util.*; 

public class xInDeck {
     public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] deck = new int[n];
        for (int i = 0; i < n; i++) {
            deck[i] = scanner.nextInt();
        }
        Solution obj = new Solution();
        if (obj.hasGroupsSizeX(deck))
            System.out.println("true");
        else
            System.out.println("false");
        scanner.close();
    }
}

class Solution {
    // Euclid's GCD Algorithm
    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int[] freq = new int[10000];
        for (int number : deck)
            freq[number]++;
        int hcf = 0;
        for (int i = 0; i < 10000; i++) {
            // gcd(0,x) = x. So we don't need to worry about freq[i] = 0 cases.
            hcf = gcd(hcf, freq[i]);
        }
        return (hcf > 1);
    }
}

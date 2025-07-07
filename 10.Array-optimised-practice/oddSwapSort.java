/*You are given an array a1,a2,…,an. You can perform operations on the array. In each operation you can choose an integer i (1≤i<n), and swap elements ai and ai+1 of the array, if ai+ai+1 is odd.
Determine whether it can be sorted in non-decreasing order using this operation any number of times. */

import java.util.*;
public class oddSwapSort {
    public static void solve(Scanner scanner) {
    
        int n = scanner.nextInt();

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x % 2 == 1) {
                odd.add(x);
            } else {
                even.add(x);
            }
        }


        if (isSorted(odd) && isSorted(even)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
    }

    public static boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t> 0) {
            solve(scanner);
            t--;
        }
        scanner.close();
    }
 

}

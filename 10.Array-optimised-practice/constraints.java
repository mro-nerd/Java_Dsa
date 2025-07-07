// #Alex is solving a problem. He has n
//  constraints on what the integer k
//  can be. There are three types of constraints:

// 1.k must be greater than or equal to some integer x
// 2.k must be less than or equal to some integer x
// 3.k must be not equal to some integer x

// Each test consists of multiple test cases. The first line contains a single integer t
//  (1≤t≤500) — the number of test cases. The description of the test cases follows.

// The first line of each test case contains a single integer n
//  (2≤n≤100) — the number of constraints.

// The following n
//  lines describe the constraints. Each line contains two integers a
//  and x
//  (a∈{1,2,3},1≤x≤109). a
//  denotes the type of constraint. If a=1, k
//  must be greater than or equal to x.If a=2, k
//  must be less than or equal to x. If a=3, k
//  must be not equal to x



import java.util.Scanner;
import java.util.Vector;

public class constraints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        for (int w = 0; w < t; w++) { // Loop through each test case
            int n = scanner.nextInt(); // Number of constraints in this test case
            Vector<Integer> v = new Vector<>(); // Vector to store 'not equal to' constraints
            int mn = 0, mx = 1000000004; // Initialize min and max constraints
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt(); // Type of constraint
                int x = scanner.nextInt(); // The value for the constraint
                if (a == 1) mn = Math.max(mn, x); // 'Greater than or equal to' constraint
                else if (a == 2) mx = Math.min(mx, x); // 'Less than or equal to' constraint
                else v.add(x); // 'Not equal to' constraint
            }
            if (mx < mn) { // If there is no valid range
                System.out.println(0);
                continue;
            }
            int cnt = mx - mn + 1; // Calculate the number of integers in the range [mn, mx]
            for (int i = 0; i < v.size(); i++) { // Adjust count for 'not equal to' constraints
                if (v.get(i) >= mn && v.get(i) <= mx) cnt--;
            }
            System.out.println(cnt); // Output the result for this test case
        }
        scanner.close();
    }
}

/*You are given an array A of size N. You have to perform Q queries on the array. Each of these queries belongs to the following types of queries:
 
 type 1=>LRX: add X to all elements in the range [L,R]
 type2=>LRX: Set the value of all elements in the range [L,R]
 to X
However, it is not mandatory to perform the queries in order. Your task is to determine the lexicographically largest array that can be obtained by performing all the . A follows 1-based indexing system
 queries. */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class differentQueries {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        long[] arr = new long[n];

        // Taking input for the array
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        // Three separate lists to store the three types of queries
        List<int[]> decrementQueries = new ArrayList<>();
        List<int[]> incrementQueries = new ArrayList<>();
        List<int[]> setQueries = new ArrayList<>();

        // Processing queries
        while (q-- > 0) {
            int t = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            if (t == 1) {
                if (x > 0) {
                    incrementQueries.add(new int[]{x, l, r});
                } else {
                    decrementQueries.add(new int[]{x, l, r});
                }
            } else {
                setQueries.add(new int[]{x, l, r});
            }
        }

        // Sorting the set queries based on the value of X to get lexicographically largest array
        Collections.sort(setQueries, Comparator.comparingInt(o -> o[0]));

        // Updating the original array
        /*To get lexicographically largest array we have to first do decrement type query then set type query and then increment type  */
        for (int[] query : decrementQueries) {
            for (int i = query[1] - 1; i < query[2]; i++) {
                arr[i] += query[0];
            }
        }
        for (int[] query : setQueries) {
            for (int i = query[1] - 1; i < query[2]; i++) {
                arr[i] = query[0];
            }
        }
        for (int[] query : incrementQueries) {
            for (int i = query[1] - 1; i < query[2]; i++) {
                arr[i] += query[0];
            }
        }

        // Outputting the updated array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }


}

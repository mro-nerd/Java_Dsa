/*The next lecture in a high school requires two topics to be discussed. The i-th topic is interesting by ai units for the teacher and by bi units for the students.

The pair of topics i and j (i<j) is called good if ai+aj>bi+bj (i.e. it is more interesting for the teacher).

Your task is to find the number of good pairs of topics.

The first line of the input contains one integer n (2≤n≤2⋅105) — the number of topics.

The second line of the input contains n integers a1,a2,…,an (1≤ai≤109), where ai is the interestingness of the i-th topic for the teacher.

The third line of the input contains n integers b1,b2,…,bn (1≤bi≤109), where bi is the interestingness of the i-th topic for the students.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class pairOfTopics {
    public static int countLarger(ArrayList<Integer> arr, int j) {
        // Let's find the first such index s.t.
        // c[i] > -c[j];
        // search range is [0, j - 1]
        int beg = 0, end = j - 1, ans = -1;

        while(beg <= end) {
            int mid = (beg + end)/2;
            if(arr.get(mid) > -arr.get(j)) {
                ans = mid;
                end = mid - 1;
            }
            else {
                beg = mid + 1;
            }
        }
        return ans == -1 ? 0 : j - ans; // because valid indices are [ans, j)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        
        for(int i = 0; i < n; ++i)
            a.add(sc.nextInt());
            
        for(int i = 0; i < n; ++i)
            b.add(sc.nextInt());
        sc.close();
        ArrayList<Integer> c = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            c.add(a.get(i) - b.get(i));

        long ans = 0;
        Collections.sort(c);
        for(int j = 0; j < n; ++j)
            ans += countLarger(c, j);

        System.out.println(ans);
    }
}

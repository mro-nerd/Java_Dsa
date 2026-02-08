import java.io.*;
import java.util.*;

public class cpA {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] a = new long[n];

            long sum = 0;
            long totalGain = 0;

            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                sum += a[i];
                totalGain += (a[i] / x) * y;
            }

            if (x == y) {
                out.append(sum).append("\n");
                continue;
            }

            long ans = 0;
            for (int i = 0; i < n; i++) {
                long cur = a[i] + (totalGain - (a[i] / x) * y);
                ans = Math.max(ans, cur);
            }

            out.append(ans).append("\n");
        }

        System.out.print(out.toString());
    }
}
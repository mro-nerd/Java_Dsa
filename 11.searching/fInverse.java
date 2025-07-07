/*f(x)=x+x/10+x/100+x/1000+...=n
 * 
 * ex: f(1234)=1234+123+12+1 =1370
 * 
 * you are here given this function f(x) and its value n find the function's inverse.
 */

import java.util.Scanner;

public class fInverse {
    public static int f(int k) {
        int ans = 0;
        while(k > 0) {
            ans += k;
            k /= 10;
        }
        return ans;
    }
    public static int fnInverse(int n) {
        int beg = 1, end = n;

        while(beg <= end) {
            int mid = (beg + end)/2;
            int fMid = f(mid);

            if(fMid == n)
                return mid;
            else if(fMid > n)
                end = mid - 1;
            else
                beg = mid + 1;
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        System.out.println(fnInverse(N));

    }
}

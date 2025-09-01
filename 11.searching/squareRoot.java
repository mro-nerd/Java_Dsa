/*Give integeral square root value of given integer n */

public class squareRoot {
    public static void main(String[] args){
        int n=8;
        System.out.println(mySqrt(n));
    }
    public static int mySqrt(int x) {
        int beg = 0, end = x, ans = -1;
        while(beg <= end) {
            // 'long' because otherwise
            // mid*mid can overflow
            long mid = (beg + end)/2;

            if(mid*mid <= x) {
                ans = (int)mid;
                beg = (int)mid + 1;
            }
            else
                end = (int)mid - 1;
        }
        return ans;
    }
}

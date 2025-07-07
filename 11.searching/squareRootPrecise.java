/*find the square root of given integer n upto p decimal places */

public class squareRootPrecise {
    public static void main(String[] args) {
        int n=18,p=4;
        double ans=mySqrt(n, p);
        double finalAns = Math.round(ans*Math.pow(10,p))/Math.pow(10,p);
        System.out.println(finalAns);
    }
    public static double mySqrt(int x, int p) {
        double beg = 0, end = x;
        double precision = Math.pow(10, -p);
        while(end - beg >= precision) {
            double mid = (beg + end)/2.0;
            if(mid*mid <= x)
                beg = mid;
            else
                end = mid;
        }
        return beg;
    }
}

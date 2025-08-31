/*Given an integer n, return true if it is a power of four. Otherwise, return false. */

public class powerFour {
    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
    public static void main(String[] args) {
        int n=16;
        boolean ans=isPowerOfFour(n);
        System.err.println(ans);
        //System.out.println(3^011);
    }

}

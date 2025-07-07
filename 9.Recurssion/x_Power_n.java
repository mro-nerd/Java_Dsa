//it is a more optimized approach to calculate power ,here time complexity is O(logn)
public class x_Power_n {
    public static int optimizedPower(int x, int n){
        if(n==0){//base case
            return 1;

        }
        int halfPower=optimizedPower(x, n/2);
        int a = halfPower*halfPower;
        if(n%2!=0){
            a=x*a;//for odd n
        }
        return a;
    } 
    public static void main(String[] args) {
        int x=7; 
        int n=10;
       System.out.println( optimizedPower(x, n));
    }
}

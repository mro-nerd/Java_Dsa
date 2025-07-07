/*Given a '2*n'floor and tiles of size '2*1' ,count the no of ways to tile the given floor(a tile can be placed horizontally or vertically) */

public class tilingProblem {
    public static int countWays(int n){
        if(n==0||n==1){//base case
            return 1;

        }
        int fnm1=countWays(n-1);//for vertical 
        int fnm2=countWays(n-2);//for horizontal 
        int totalWays=fnm1+fnm2;
        return totalWays;
    }
    public static void main(String[] args) {
        int n=7;
        System.out.println(countWays(n));
    }
}

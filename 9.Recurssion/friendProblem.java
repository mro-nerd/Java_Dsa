/* Given 'n' friends, each one cam remain single or can be paired up with some other friend. Each friend can be paired only once . find out total number of ways in which friends can remain single or can be paired up. */
public class friendProblem {
    public static int friendPairing(int n){
        if(n==1||n==2){//base case
            return n;
        }
        //for single
        int fnm1=friendPairing(n-1);
        //for pairs
        int fnm2=friendPairing(n-2);
        int pairways=(n-1)*fnm2; //since there are n-1 ways to pair and after that pair is made then fnm2 function will work
        int totalWays=fnm1+ pairways;
        return totalWays;
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(friendPairing(n));

    }
}

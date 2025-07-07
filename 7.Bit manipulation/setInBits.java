//here we are counting the number of 1(s) in any binary no.
public class setInBits {

    public static int countSetBits(int n){
        int count=0;
        while (n>0) {
            if((n&1)!=0)//checking lsb
            {
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(15));
    }
}

//it is used to clear or convert the i th bit into zero

public class clearBit {
    public static int clearIthBit(int n, int i){
        int bitMask=~(1<<i);
        return n&bitMask;
    }
    //it is used to clear or convert the i bits into zero
    public static int clearIBits(int n, int i){
        int bitMask=~(0)<<i;//~0=-1 or 11111 in binary
        return n&bitMask;
    }
    public static int clearBitsInrange(int n, int i,int j){
        int a=~(0)<<(j+1);
        int b=(1<<i)-1;
        int bitMask=a|b;

        return n&bitMask;
    }
    
    public static void main(String[] args) {
        System.out.println(clearIthBit(10,1));
        System.out.println(clearIBits(15,2));
        System.out.println(clearBitsInrange(15,2,4));

    }
}

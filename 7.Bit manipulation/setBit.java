//setting or converting ith bit to 1
public class setBit {
    public static int setIthBit(int n , int i){
        int bitMask=1<<i;
      return n | bitMask;
    }
    public static void main(String[] args) {
       System.out.println(setIthBit(5, 1));
    }
}

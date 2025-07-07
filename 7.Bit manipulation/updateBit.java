//this fn lets you set as well as clear the i th bit according to your choice

public class updateBit {

    public static int clearIthBit(int n , int i){
        int bitMask=~(1<<i);
      return n &bitMask;
    }
    public static int updateIthBit(int n, int i , int newBit){
        n=clearIthBit(n,i);
        int Bitmask=newBit<<i;
        return n|Bitmask;
    }
    public static void main(String[] args) {
       System.out.println(updateIthBit(10, 1,0));
    }


}

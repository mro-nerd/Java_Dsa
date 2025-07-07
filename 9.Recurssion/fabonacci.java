public class fabonacci {
    public static void main(String[] args){
        int n=5;
        System.out.println(fb(n));

    }
    public static int fb(int n){
          if(n==0 || n==1){//base class
            return n;
          }
          int fn = fb(n-1)+fb(n-2);
          return fn;
    }
}

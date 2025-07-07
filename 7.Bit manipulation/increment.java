public class increment {
    public static void main(String[] args) {
        int a=10;
        System.out.println("a+1:"+ -~a);
    }
}
//as we get negative no. by taking its complement and adding 1 (2's complement)
// i.e ,  -x=~x+1
//      =>-~x=x+1 
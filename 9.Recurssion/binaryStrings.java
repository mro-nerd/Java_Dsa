public class binaryStrings {
    public static void binaryStringPrint(int n,int lastPlace , String str){
        if(n==0){//base case
            System.out.println(str);//when all places are filled then we need to print the binary string
            return;
        }
        if(lastPlace==0){
            binaryStringPrint(n-1, 0, str+"0");
            binaryStringPrint(n-1, 1, str+"1");
        }else{
            binaryStringPrint(n-1,0,str+"0");
        }
    } 
    public static void main(String[] args) {
        int n=4;
        binaryStringPrint(n, 0, "");
    }
}

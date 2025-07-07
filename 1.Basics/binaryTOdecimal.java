public class binaryTOdecimal {

    public static void binToDec(int bin){
          int pow=0;
          int dec = 0;
          while(bin>0){
            int lastDigit = bin%10;
            dec = dec + (lastDigit*(int)Math.pow(2,pow));
            pow++;
            bin = bin/10;
          }
          System.out.println("decimal is "+dec);
    }
    public static void main(String[] args) {
        binToDec(110);
    }
}

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        System.out.println("Enter your number:-");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Reverse of your number:-");
        while (n>0) {
            int lastDigit = n%10;
            System.out.print(lastDigit);
            n=n/10;
        }
       System.out.println();
        sc.close();

        

    }
}

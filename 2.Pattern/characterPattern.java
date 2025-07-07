import java.util.Scanner;

public class characterPattern {
    public static void main(String[] args) {
        System.out.println("Enter no. of rows");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char ch= 'A';
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(ch);
                ch++;


            }
            System.out.println();
        }
        sc.close();

    }
}

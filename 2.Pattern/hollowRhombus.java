import java.util.Scanner;

public class hollowRhombus {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows");
        int n = sc.nextInt();
        

        for (int i = 1; i <= n; i++) {
            //first get spaces
            for (int j = 1; j <=n - i; j++) {
                System.out.print(" ");
            }
            //then code of hollow rectangle ,due to spces this rec will tilt to become rhombus
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
        sc.close();
    }
}

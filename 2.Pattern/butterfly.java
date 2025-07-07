import java.util.Scanner;

public class butterfly {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter no. of rows");
        int n= sc.nextInt();
        //upper half
        for (int i =1 ; i <=n; i++) {
           //for star
            for(int j =1; j<=i;j++){
                System.out.print("*");
             }
            //for spaces 
            for (int k = 1; k <=2*(n-i); k++) {
                System.out.print(" ");
                
            } 
            //for star
            for(int l =1; l<=i;l++){
                System.out.print("*");
             }
          
            System.out.println();
        }
        //lower half
        for (int a =n ; a >=1; a--)//desc outer loop
         {
           //same inner loop
            for(int j =1; j<=a;j++){
                System.out.print("*");
             }
            for (int k = 1; k <=2*(n-a); k++) {
                System.out.print(" ");
                
            } 
            for(int l =1; l<=a;l++){
                System.out.print("*");
             }
          
            System.out.println();
        }
        sc.close();
    }
}

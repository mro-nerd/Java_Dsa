 import java.util.Scanner;
public class mirrorHalfPyramid {
   public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter no. of rows");
        int n= sc.nextInt();
        
        for (int i =1 ; i <=n; i++) {
            //for spaces
            for(int j =1; j<=n-i;j++){
               
                System.out.print(" ");
               

            }
            //for starts
            for(int l =1 ; l<=i; l++){
                 System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
 
}

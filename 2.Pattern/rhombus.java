import java.util.Scanner;

public class rhombus {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter no. of rows");
        int n= sc.nextInt();
       
        for (int i =1 ; i <=n; i++) {
           
          //for spaces
            for (int k = 1; k <=(n-i); k++) {
                System.out.print(" ");
                
            } 
           //for stars
            for(int l =1; l<=n;l++){
                System.out.print("*");
             }
          
            System.out.println();
        }
      
        sc.close();
    }
}
